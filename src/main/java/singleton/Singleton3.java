package singleton;

/**
 * 饿汉式，根据类初始化加载，没有懒加载（用到的时候再去加载），易产生垃圾对象
 */
public class Singleton3 {
    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return singleton3;
    }
}
