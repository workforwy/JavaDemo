package oper;

public class OperDemo7 {
    public static void main(String[] args) {
        // 移位运算符
        // 1)有符号移位:>>,<< (永远补符号位)
        // 2)无符号移位:>>> (高位永远补0)

        byte a = 8;
        // 00001000
        int a1 = a >> 2;// 00000010
        System.out.println("a1=" + a1);
        int a2 = a << 2;// 00100000
        System.out.println("a2=" + a2);

        int b = -8;

        // 10001000 原码
        // 11110111 去反
        // 11111000 加1
        // 11111110 右移2位
        // 10000001取反
        // 10000010加1
        // 负数在参与运算时先转换为补码
        int b1 = b >> 2;
        System.out.println("b1=" + b1);

        // 无符号移位(高位补0)

        int c = -8;
        int c1 = c >>> 2;
        System.out.println("c1=" + c1);

        // 说明，无符号没有左移
    }
}
