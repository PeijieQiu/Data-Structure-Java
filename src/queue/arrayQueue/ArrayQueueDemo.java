package queue.arrayQueue;

public class ArrayQueueDemo<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private AnyType[] theArray;
    private int capacity = DEFAULT_CAPACITY;
    private int currentSize;
    private int front = -1;
    private int back = -1;

    public ArrayQueueDemo() {
        theArray = (AnyType[]) new Object[this.capacity];
        currentSize = 0;
    }

    public ArrayQueueDemo(int capacity) {
        this.capacity = capacity;
        theArray = (AnyType[]) new Object[this.capacity];
        currentSize = 0;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean isFull() {
        return this.capacity == this.size();
    }

    public boolean enqueue(AnyType element) {

        if (isFull())
            ensureCapacity(this.capacity*2);

        if (back==this.capacity-1)
            back = -1;

        currentSize++;
        theArray[++back] = element;

        return true;
    }

    public AnyType dequeue() {

        if (front == this.capacity - 1)
            front = -1;

        currentSize--;
        front++;

        return theArray[front];
    }

    public void retrieve() {
        for (int i=0;i<this.size();i++)
            System.out.println(theArray[i]);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < this.size())
            return;

        AnyType[] old = theArray;
        theArray = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theArray[i] = old[i];
        }
    }

    public AnyType[] getTheArray() {
        return theArray;
    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }
}
