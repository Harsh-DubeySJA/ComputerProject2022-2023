interface Queue {
    void add(int data);
    int remove();
    boolean isEmpty();
}

class QueueImplementation implements Queue {

    private final int[] data;
    private int front, rear;

    public QueueImplementation(int size) {
        data = new int[size];
        front = -1;
        rear = -1;
    }

    public QueueImplementation() {
        data = new int[10];
        front = -1;
        rear = -1;
    }

    public void add(int data) {
        try {
            if (!isEmpty()) {
                this.data[rear++] = data;
            } else {
                this.data[++front] = data;
                rear = 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Overflow: No Space Left");
        }
    }

    public int remove() {
        int data;
        if (!isEmpty() && front <= rear) {
            data = this.data[front++];
        } else throw new RuntimeException("Underflow: Queue is Empty");
        return data;
    }

    public boolean isEmpty() {
        return front == rear;
    }
}
