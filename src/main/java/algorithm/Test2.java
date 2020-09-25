package algorithm;


public class Test2 {

    public static void main(String[] args) {
        int n = 3;
        Boolean negative = n < 0;
        double res = helper(8, n);
        double m = negative ? 1 / res : res;
        System.out.println(m);
    }

    private static double helper(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            double res = helper(x, n / 2);
            return res * res * x;
        } else {
            double res = helper(x, n / 2);
            return res * res;
        }
    }
}
