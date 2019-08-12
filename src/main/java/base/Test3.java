package base;

import singleton.Singleton1;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("输入整数：");
        int n = new Scanner(System.in).nextInt();
    /*
     * 1.n向右移动24位再强转成byte赋b1
     * 2.n向右移动16位再强转成byte赋b2
     * 3.n向右移动8位再强转成byte赋b3
     * 4.n向右移动0位再强转成byte赋b4
     */
        byte b1 = (byte) (n >> 24);
        byte b2 = (byte) (n >> 16);
        byte b3 = (byte) (n >> 8);
        byte b4 = (byte) (n >> 0);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

    /*
     * 1.b1向左移动24位再不带符号右移0位，再与r求位或，结果重新赋给r
     * 2.b1向左移动24位再不带符号右移8位，再与r求位或，结果重新赋给r
     * 3.b1向左移动24位再不带符号右移16位，再与r求位或，结果重新赋给r
     * 4.b1向左移动24位再不带符号右移24位，再与r求位或，结果重新赋给r
     */
        int r = 0;
        r = r | (b1 << 24 >>> 0);
        System.out.println(r);
        r = r | (b2 << 24 >>> 8);
        System.out.println(r);
        r = r | (b3 << 24 >>> 16);
        System.out.println(r);
        r = r | (b4 << 24 >>> 24);
        System.out.println(r);

        Singleton1.INSTANCE.get();
    }
}
