package algorithm;

/**
 * 字符移动算法
 */
public class Test3 {
    public static void main(String[] args) {
        //        char[] s = {'a', 'b', 'c', 'd', 'e'};
        //        //        LeftRotateString(s, 3, 2);
        //        //        LeftShiftOne(s,3);
        //        ReverseString(s, 3, 4);
        //        System.out.println(s);
        System.out.println(9);
    }

    private static void LeftShiftOne(char[] s, int n) {
        char t = s[0];  //保存第一个字符
        for (int i = 1; i < n; i++) {
            s[i - 1] = s[i];
        }
        s[n - 1] = t;
    }

    private static void LeftRotateString(char[] s, int n, int m) {
        while (m-- > 0) {
            LeftShiftOne(s, n);
        }
    }

    private static void ReverseString(char[] s, int from, int to) {
        while (from < to) {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
    }

    static int lowbit(int x) {
        return x & -x;
    }
}
