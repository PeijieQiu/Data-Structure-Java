public class MaxDivisor {

    public static long gcd(long m, long n) {

        if (m < n) {
            long temp = n;
            n = m;
            m = temp;
        }

        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }

        return m;
    }

    public static void main(String[] args) {
        System.out.println(gcd(1590,1989));
    }
}
