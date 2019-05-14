public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * performs the standard binary search
     *
     * @return index where item is found, or -1 if not found.
     */
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch2(AnyType[] a, AnyType x, int low, int high) {

        int mid = (low + high) / 2;

        if (a[mid].compareTo(x) == 0) {
            return mid;
        } else if (a[mid].compareTo(x) < 0) {
            return binarySearch2(a, x, mid, high);
        } else if (a[mid].compareTo(x) > 0) {
            return binarySearch2(a, x, low, mid - 1);
        } else
            return NOT_FOUND;

    }

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch2(AnyType[] a, AnyType x) {
        return binarySearch2(a, x, 0, a.length - 1);
    }

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x){
        int low=0,high=a.length-1;
        while (low<=high){
            int mid=(low+high)/2;

            if (a[mid].compareTo(x)<0)
                low=mid+1;
            else if (a[mid].compareTo(x)>0)
                high=mid-1;
            else
                return mid;
        }

        return NOT_FOUND;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[1000];
        for (int i=0; i<1000;i++){
            a[i]= i;
        }

        long startTime1 = System.currentTimeMillis();
        System.out.println(binarySearch2(a, 33));
        long endTime1 = System.currentTimeMillis();


        long startTime2 = System.currentTimeMillis();
        System.out.println(binarySearch(a, 33));
        long endTime2 = System.currentTimeMillis();

        System.out.println("Operation Time 1:"+(endTime1-startTime1)+"--Operation Time 2:"+(endTime2-startTime2));
    }
}
