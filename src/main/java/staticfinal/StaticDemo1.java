package staticfinal;

class Static01 {
    /**
     * 类变量 1)类加载时执行默认初始化 2)多个类变量，初始化顺序从上到下 3)类变量所有对象(类的实例)共享一份
     */
    static int count1;
    static int count2;

    /**
     * 静态代码块 1)类加载时执行，且只执行一次 2)通常可以在此方法中对类变量赋值或者 去读取一些配置文件等。 3)只能访问使用static修饰的成员
     */
    static {
        count1 = 10;
        count2 = 10;
        // prepare();
    }// 是类变量先默认初始化还是static代码块先执行

    /**
     * 静态方法(类方法) 1)可以通过类名直接访问 2)此方法内部只能访问静态成员 3)允许重写，但不支持多态
     */
    static void prepare() {
        System.out.println("Super");
    }
}

class SubStatic01 extends Static01 {
    static void prepare() {
        System.out.println("Sub");
    }
}

public class StaticDemo1 {
    public static void main(String[] args) {
        Static01 s = new SubStatic01();
        s.prepare();
    }
}

