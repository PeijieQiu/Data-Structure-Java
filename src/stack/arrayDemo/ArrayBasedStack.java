package stack.arrayDemo;

public class ArrayBasedStack<AnyType> {

    private AnyType[] arr;
    private int capacity;
    private int top = -1;
    private int currentSize = 0;

    public ArrayBasedStack(int capacity) {
        this.capacity = capacity;
        arr = (AnyType[]) new Object[capacity];
    }

    public boolean push(AnyType element) {

        if (isFull()) {
            return false;
        }

        currentSize++;
        arr[++top] = element;
        return true;
    }

    public AnyType pop() {

        if (isEmpty()) {
            return null;
        }

        this.currentSize--;
        AnyType result = arr[top];
        arr[top] = null;//prevent memory leaking
        top--;
        return result;
    }

    public AnyType top() {
        return arr[top];
    }

    public String toString() {
        if (this.size() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append(arr[i] + ", ");
        }

        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.size() == this.capacity) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.currentSize;
    }
}
