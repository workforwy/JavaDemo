package utils;

/**
 * 打印工具类
 */
public class Log {

    public static void d(String info, String message) {
        System.out.println(info + "  " + message);
    }

    public static void d(String message) {
        d("123", message);
    }

}
