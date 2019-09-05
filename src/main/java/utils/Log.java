package utils;

/**
 * 打印工具类
 */
public class Log {

    public static void d(String info, String message) {
        System.out.println(info + "  " + message);
    }

    public static void d(Object info) {
        System.out.println(info);
    }

    public static void i(String info) {
        System.out.println(info);
    }

    public static void i(String info, String message) {
        System.out.println(info + "  " + message);
    }

    public static void e(String info, String message) {
        System.out.println(info + "  " + message);
    }


}
