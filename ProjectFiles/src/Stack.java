interface Stack {
    void push(char ch);
    char pop();
    boolean isEmpty();
}

class LinkedStack implements Stack {
    static class Node {
        char ch;
        Node next;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    private Node top;
    public LinkedStack() {
        top = null;
    }

    public void push(char ch) {
        try {
            Node newNode = new Node(ch);
            newNode.next = top;
            top = newNode;
        } catch (OutOfMemoryError e) {
            throw new RuntimeException("Overflow: Out of memory");
        }
    }

    public char pop() {
        char ch;
        if (!isEmpty()) {
            ch = top.ch;
            top = top.next;
        } else {
            throw new RuntimeException("Underflow: No Element Left");
        }
        return ch;
    }

    public boolean isEmpty() {
        return top == null;
    }
}