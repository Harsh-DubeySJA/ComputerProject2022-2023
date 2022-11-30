interface StackArray {
    void push(int data);
    int pop();
    boolean isEmpty();
}

class StackA implements StackArray {
    private int[] a;
    private int size, allocation;

    StackA(int size) {
        this.size = size;
        a = new int[size];
    }

    StackA() {
        size = 10;
        a = new int[size];
    }

    public void push(int data) {
        if (allocation < size) {
            a[allocation++] = data;
        } else throw new RuntimeException("Overflow");
    }

    public int pop() {
        if (!isEmpty()) {
            return (a[allocation--] = 0);
        } else {
            throw new RuntimeException("Underflow: No element left");
        }
    }

    public boolean isEmpty() {
        return (allocation >= 0);
    }
}
