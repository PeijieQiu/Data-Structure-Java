public class maxSubSum {

    /**
     * Cubic maximum contiguous sub-sequence sum algorithm
     *
     * @param a
     * @return
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += a[k];

                    if (thisSum > maxSum)
                        maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Quadratic maximum contiguous sub-sequence sum algorithm
     *
     * @param a
     * @return
     */
    public static int maxSubSum2(int[] a) {

        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {

            int thisSum = 0;

            for (int j = i; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum > maxSum)
                    maxSum = thisSum;

            }
        }
        return maxSum;
    }

    /**
     * Linear-time maximum contiguous sub-sequence sum algorithm
     *
     * @param
     */
    public static int maxSubSum4(int[] a) {

        int maxSum = 0, thisSum = 0;

        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];

            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSum;
    }

    /**
     * Recursive maximum contiguous sub-sequence sum algorithm.
     * Finds maximum sum in sub-arrays spanning a[left...right].
     * Does not attempt to maintain actual best sequence.
     */

    private static int maxSumRec(int[] a, int left, int right) {

        if (left == right) //Base Case
            if (a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i < right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }


    private static int max3(int maxLeftBorderSum, int maxRightBorderSum, int i) {
        int max = maxLeftBorderSum;

        if (maxRightBorderSum > max && maxRightBorderSum > i)
            max = maxRightBorderSum;
        else if (maxRightBorderSum > max && maxRightBorderSum < i)
            max = i;
        else if (i > max)
            max = i;

        return max;
    }


    /**
     * @param a
     * @return
     */
    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    /**
     * Test
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {2, -3, 7, -2, -1, 2, 6, -2};
        System.out.println(maxSubSum1(a));
        System.out.println(maxSubSum2(a));
        System.out.println(maxSubSum3(a));
        System.out.println(maxSubSum4(a));
    }
}
