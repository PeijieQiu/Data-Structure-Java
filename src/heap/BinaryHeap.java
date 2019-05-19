package heap;

import java.nio.BufferUnderflowException;
import java.util.Arrays;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize; //Number of elements in heap
    private AnyType[] array; //The heap array

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (AnyType[]) new Comparable[capacity];
        currentSize = 0;
    }

    /**
     * Construct the binary heap given an array of items.
     *
     * @param items
     */
    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     *
     * @param x the item to insert.
     */

    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        //Percolate up
        int hole = ++currentSize;
        for (; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();

        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw UnderflowException, if empty.
     */
    public AnyType deleteMin() {
        if (isEmpty())
            throw new BufferUnderflowException();

        AnyType minItems = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        array[currentSize+1]=null;
        return minItems;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        for (int i = 0; i < array.length; i++)
            array[i] = null;

        currentSize = 0;
    }

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize) {
        AnyType[] oldArray = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "currentSize=" + currentSize +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
