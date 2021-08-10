package oper;

public class OperDemo1 {
    public static void main(String[] args) {
        int a = 10;
        // 将a+10的结果重新赋值给a
        a = a + 10;// a=20
        // a除以10的值再次赋值给,只取整数
        a = a / 10;// a=20/10=2
        System.out.println(a);

        // ======================
        int b = 10;
        // b=b/0;//除数不能为0
//		System.out.println("b=" + b / 0);

        float f1 = 10.1f;
        f1 = f1 / 0;// 结果为Infinity
        System.out.println("f1=" + f1);

        double d = 10;
        d = d * 10;
        System.out.println("d=" + d);

        double d1 = 10.0 / 3;
        double d2 = 10 / 3;
        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        // Java中的Math类为一个工具类，它提供了很多使用static修饰的方法，便于我们进行一些算数运算
        // 向下
        System.out.println(Math.floor(d1));
        // 向上
        System.out.println(Math.ceil(d1));
        // 四舍五入
        System.out.println(Math.round(12.3));
        // 获得一个随机数(>=0&&<1)
        System.out.println(Math.random());

        double s0 = Math.abs(-9);// 9
        double s1 = Math.sqrt(9);// 3


    }
}
