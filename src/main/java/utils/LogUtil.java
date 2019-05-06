package utils;

/**
 * 打印日志工具类
 */
public class LogUtil {
    public static void info(String info) {
        System.out.println(
                info
        );
    }

    public static void info(String info, String message) {
        System.out.println(
                info + "  " + message
        );
    }

    public static void error(String info, String message) {
        System.out.println(
                info + "  " + message
        );
    }
}
