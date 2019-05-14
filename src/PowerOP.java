public class PowerOP {

    /**
     * Power Operation
     *
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }

    public static void main(String[] args) {
        System.out.println(pow(2,32));
    }
}
