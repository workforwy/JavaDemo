package sort;

public class Test2 {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        print(test);
        print(transponse(test));
    }

    /**
     * 打印数组
     *
     * @param arr
     */

    static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("\n");
        }

    }

    /**
     * 写一个函数计算但参数为n（n很大）时的值1-2+3-4+5-6+7……+n
     */
    static void fun1() {
        int n = 1000;
        int sum = 0;
        if (n % 2 == 0) {
            sum = -(n / 2);
            System.out.println("" + sum);
        } else {
            sum = -(n - 1) / 2 + n;
            System.out.println("" + sum);
        }
    }

    /**
     * 下面程序段的输出结果是
     */
    static void fun2() {
        int x = 20, y = 30;
        boolean b;
        b = x > 50 && y > 60 || x > 50 && y < -6 || x < -50 && y > 60 || x < -50 && y < -60;
        System.out.println(b);
    }

    /**
     * 请写一个整数组成的矩阵转置程序，行变成列，列变成行
     */
    static int[][] transponse(int[][] t) {
        int[][] f = new int[t[0].length][t.length];
        for (int i = 0; i < t.length; i++) {
            int index = 0;
            index++;
            for (int x = 0; i < t[i].length; i++) {
                int m = 0;
                m++;
                f[m][index] = t[i][x];
            }
        }
        return f;
    }

    /**
     * 冒泡排序
     */
    static void fun3() {
        int[] a = null;
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 最有效率的方法算出2乘以8
     */
    static void fun4() {
        System.out.print(2 << 3);
    }

    static void fun5() {
        Math.round(11.5);//12
        Math.round(-11.5);//-11
    }

    /**
     * 第一条语句打印的结果为false，第二条语句打印的结果为true，
     * 这说明javac编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。
     * 题目中的第一行代码被编译器在编译时优化后，相当于直接定义了一个”abcd”的字符串，所以，上面的代码应该只创建了一个String对象。
     */
    static void fun6() {
        String s = "a" + "b" + "c" + "d";
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";

        System.out.println(s2 == "ab"); // false
        System.out.println(s3 == "ab");  // true
        System.out.println(s == "abcd");// true
    }
}
