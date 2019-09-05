package singleton;

/**
 * 懒汉式，未初始化
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (singleton1 == null)
            return new Singleton1();
        else
            return singleton1;
    }
}
