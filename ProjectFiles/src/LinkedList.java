public class LinkedList {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int data = 1; data <= 5; data++) {
            l.addNodeAtEnd(data);
        }
        l.display();
        System.out.println(l.length());
        System.out.println(l.search(5));
        l.displayReverse();
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    class OverflowException extends RuntimeException {
        public OverflowException() {
            super("Overflow: No memory left");
        }

        public String toString() {
            return "OverflowException: No memory left";
        }
    }

    class UnderflowException extends RuntimeException {
        public UnderflowException() {
            super("Underflow: No node left");
        }

        public String toString() {
            return "UnderflowException: No node left";
        }
    }

    private Node start;

    public LinkedList() {
        start = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void addNodeAtEnd(int data) {
        try {
            Node newNode = new Node(data);
            if (isEmpty())
                start = newNode;
            else {
                Node last = start;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        } catch (OutOfMemoryError e) {
            throw new OverflowException();
        }
    }

    public void addNodeAtBeg(int data) {
        try {
            Node newNode = new Node(data);
            if (isEmpty())
                start = newNode;
            else {
                newNode.next = start;
                start = newNode;
            }
        } catch (OutOfMemoryError e) {
            throw new OverflowException();
        }
    }

    public int removeNodeFromBeg() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        int data = start.data;
        start = start.next;
        return data;
    }

    public int removeNodeFromEnd() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        int data;
        if (start.next == null) {
            data = start.data;
            start = null;
        } else {
            Node last = start, secondLast = null;
            while (last.next != null) {
                secondLast = last;
                last = last.next;
            }
            data = last.data;
            secondLast.next = null;
        }
        return data;
    }

    // public void display(){
    // Node temp = start;
    // while( temp!= null ){
    // System.out.print(temp.data+" ");
    // temp = temp.next;
    // }
    // System.out.println();
    // }
    public void display() {
        displayRecursive(start);
    }

    public void displayRecursive(Node temp) {
        if (temp == null){
            System.out.println();
            return;
        }else {
            System.out.print(temp.data + " ");
            displayRecursive(temp.next);
        }
    }

    public void addNodeAtPos(int data, int pos) {
        try {
            Node temp = start;
            Node newNode = new Node(data);
            if (pos == 1) {
                newNode.next = start;
                start = newNode;
            } else {
                for (int i = 1; i < pos - 1; i++) {

                    if (temp == null || temp.next == null) {
                        throw new IllegalArgumentException();
                    }
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }

        } catch (OutOfMemoryError e) {
            start = null;
            throw new OverflowException();
        }
    }

    public int removeNodeFromPos(int pos) {
        Node temp = start;
        int data;
        if (isEmpty()) {
            throw new UnderflowException();
        } else if (pos < 1) {
            throw new UnderflowException();
        } else {
            for (int x = 1; x < pos - 1; x++) {
                temp = temp.next;
                if (temp.next == null) {
                    throw new UnderflowException();
                }
            }
            data = (temp.next).data;
            temp.next = (temp.next).next;
            return data;
        }
    }

    public int length() {
        return lengthRecursive(start, 0);
    }

    public int lengthRecursive(Node temp, int count) {
        if (temp == null) {
            return count;
        } else {
            return lengthRecursive(temp.next, count+1);
        }
    }

    public int search(int item) {
        return searchItem(start, item, 0);
    }

    private int searchItem(Node temp, int item, int pos) {
        if (temp.data == item) return pos;
        else return searchItem(temp.next, item, pos+1);
    }

    public void displayReverse() {
        displayReverseRecursive("", start);
    }

    private void displayReverseRecursive(String reverse, Node temp) {
        if (temp.next == null) {
            System.out.println(temp.data + reverse);
        } else {
            displayReverseRecursive(" " + temp.data + reverse, temp.next);
        }
    }
}