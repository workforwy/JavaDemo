package algorithm;

/**
 * 字符移动算法
 */
public class Test3 {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e'};

        leftRotateString(s, 3, 2);
        leftShiftOne(s, 3);
        reverseString(s, 3, 4);

        System.out.println(s);
        System.out.println(9);
    }

    private static void leftShiftOne(char[] s, int n) {
        //保存第一个字符
        char t = s[0];
        for (int i = 1; i < n; i++) {
            s[i - 1] = s[i];
        }
        s[n - 1] = t;
    }

    private static void leftRotateString(char[] s, int n, int m) {
        while (m-- > 0) {
            leftShiftOne(s, n);
        }
    }

    private static void reverseString(char[] s, int from, int to) {
        while (from < to) {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
    }

    private static int lowbit(int x) {
        return x & -x;
    }
}
