class QueueList implements Queue {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node front, rear;
    public void add(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            rear = front = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int remove() {
        if (!isEmpty()) {
            int head = front.data;
            front = front.next;
            if (front == rear) {
                rear = null;
            }
            return head;
        } else {
            throw new RuntimeException("");
        }
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public static void main(String[] args) {
        Queue queue = new QueueList();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}