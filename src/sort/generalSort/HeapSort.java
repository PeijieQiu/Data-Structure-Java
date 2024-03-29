package sort.generalSort;

public class HeapSort {

    /**
     * Internal method for heapsort.
     *
     * @param i the index of an item in the heap.
     * @return the index of the left child
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    public static <AnyType extends Comparable<? super AnyType>>
    void heapsort(AnyType[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--)
            percDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void swapReferences(AnyType[] a, int i, int n) {
        AnyType tmp = a[i];
        a[i] = a[n];
        a[n] = tmp;
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        Integer[] a = {10, 9, 7, 5, 4, 2, 1};
        heapsort(a);
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
