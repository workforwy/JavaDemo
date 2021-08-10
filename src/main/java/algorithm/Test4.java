package algorithm;

import utils.Log;

import java.util.HashMap;

/**
 * n级阶梯，每次走一步或两步，问最多有多少种走法
 */

public class Test4 {

    public static void main(String[] args) {
        Log.d(String.valueOf(getStepNumber(9)));
    }

    /**
     * 时间复杂度 O(2 ^ N)
     *
     * @param n
     * @return
     */
    private static long getStepNumber(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return getStepNumber(n - 1) + getStepNumber(n - 2);
    }

    /**
     * (备忘录算法) 时间复杂度是O(N)
     *
     * @param n
     * @param hashMap
     * @return
     */

    private static int getClimbCount(int n, HashMap<Integer, Integer> hashMap) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            int value = getClimbCount(n - 1, hashMap) + getClimbCount(n - 2, hashMap);
            hashMap.put(n, value);
            return value;
        }
    }

    /**
     * 时间复杂度是O(N)
     *
     * @param n
     * @return
     */
    private static int getClimb(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int sum = 0;

        for (int index = 3; index <= n; index++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    private static long getStepNumber1(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        if (n > 3) {
            return getStepNumber1(n - 1) + getStepNumber1(n - 2) + getStepNumber1(n - 3);
        }
        return 0;
    }
}
