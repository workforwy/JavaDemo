package oper;

public class OperDemo3 {
    public static void main(String[] args) {
        byte t1 = 10;
        // 当执行t1+10表达式的结果类型会自动提升为int类型
        byte t2 = (byte) (t1 + 10);
        byte t3 = t1 += 10;// 没有类型提升

        double var01 = 10.2 + 1.2f + 10;
        float var02 = 1.2f + 10;
        double l = 100L + 10;

        System.out.println(l);

        int var03 = 'A' + 1;// 66
        System.out.println(var03);

        int var04 = '中';
        System.out.println(var04);
    }
}
