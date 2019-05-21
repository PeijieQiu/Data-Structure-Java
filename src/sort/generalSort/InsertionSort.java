package sort.generalSort;

public class InsertionSort {
    /**
     * Simple insertion sort.
     *
     * @param a         an array of Comparable items.
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType[] a) {
        int j;

        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        Integer[] a = {10, 9, 7, 5, 4, 2, 1};
        insertionSort(a);
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}
