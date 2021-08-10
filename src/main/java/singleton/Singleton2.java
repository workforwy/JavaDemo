package singleton;

/**
 * 懒汉式，未初始化，因为synchronized ，多线程下需要等待，导致效率比较低，
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            return new Singleton2();
        } else
            return singleton2;
    }
}
