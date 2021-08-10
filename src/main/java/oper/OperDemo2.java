package oper;

public class OperDemo2 {
    public static void main(String[] args) {
        int a1 = 10, a2;
        a2 = a1++;
        // 后加加(先有表达式的值,表达式的值为运算(++)之前的值,然后a1自身加1)
        System.out.println("a1=" + a1);
        System.out.println("a2=" + a2);

        // ===========================
        int a3 = 10, a4;
        a4 = ++a3;// a3先自身加1然后将其值赋值给a4;

        System.out.println("a3=" + a3);
        System.out.println("a4=" + a4);

        // ==========================

        int a5 = 10, a6;

        a6 = (a5++) + (a5++) + (a5++);
        System.out.println("a5=" + a5);// 13
        System.out.println("a6=" + a6);// 33

        int a7 = 10, a8;
        a8 = (++a7) + (a7++) + (++a7);
        System.out.println("a7=" + a7);
        System.out.println("a8=" + a8);

        // =============================

        int a9 = 10;
        a9 = a9++;
        System.out.println("a9 = " + a9);

        // int temp=a9++;//10
        // a9=a9+1;//a=11
        // a9=temp;//a=10;

        int a10 = a9++;

        // int temp=a++;//10
        // a9=a9+1//a9=11
        // a10=temp;//a10=10

        int c = 10;
        c = ++c;
        System.out.println("c=" + c);
        System.out.println("float = " + Float.parseFloat("123"));
    }
}
