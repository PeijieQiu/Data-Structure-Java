package sort.generalSort;

public class ShellSort {

    /**
     * ShellSort, using Shell's (poor) increments.
     *
     * @param a         an array of Comparable items.
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a) {
        int j;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        }
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        Integer[] a = {10, 9, 7, 5, 4, 2, 1};
        shellSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
