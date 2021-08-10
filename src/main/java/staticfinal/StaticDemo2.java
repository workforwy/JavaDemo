package staticfinal;

class Static02 {

    String data01 = getData01();

    static String data02 = getData02();

    static String data03 = getData03();

    public String getData01() {
        System.out.println("data01");
        return "data01";
    }

    static String getData02() {
        return "data02";
    }

    static String getData03() {
        return "data03" + data02.toUpperCase();
    }

    public Static02() {
        System.out.println("Static02()");
    }

    static {
        System.out.println("static{}");
    }
}

public class StaticDemo2 {
    public static void main(String[] args) {
        // 定义类时不会加载类
        Static02 s;
        // 构建对象时首先会加载Static02类
        // 会执行静态代码块
        s = new Static02();// 类的对象

    }
}
