package algorithm;

/**
 * 递归算法
 */
public class Test {

    public static void main(String[] args) {

    }

    /**
     * 递归之汉诺塔算法
     */
    private static void hanio(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println("移动" + n + "号盘子从" + a + "到" + c);
        else {
            hanio(n - 1, a, c, b);//把上面n-1个盘子从a借助b搬到c
            System.out.println("移动" + n + "号盘子从" + a + "到" + c);//紧接着直接把n搬动c
            hanio(n - 1, b, a, c);//再把b上的n-1个盘子借助a搬到c
        }
    }

    /**
     * 递归
     */
    private static long recursion(int n) {
        long result = 0;
        if (n <= 2) {
            result = 1;
        } else {
            result = recursion(n - 1) + recursion(n - 2);
        }
        return result;
    }

    /**
     * 递归实例：显示九九乘法表
     */
    private static void mTable(int i) {
        if (i == 1) {
            System.out.println("1*1=1 ");
        } else {
            mTable(i - 1);
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
    }

    interface test {
        abstract void v1();
    }

}