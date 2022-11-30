// Stack with LinkedList
interface StackList {
    void push(int data);
    int pop();
    boolean isEmpty();
}

class StackLinkedList implements StackList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public StackLinkedList() {
        top = null;
    }


    public void push(int data) {
        try {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Overflow: No memory");
        }
    }


    public int pop() {
        int data;
        if (!isEmpty()) {
            data = top.data;
            top = top.next;
        } else {
            throw new RuntimeException("Underflow: No element left");
        }
        return data;
    }


    public boolean isEmpty() {
        return top == null;
    }
}
