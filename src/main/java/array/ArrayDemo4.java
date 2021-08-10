package day05;

import java.util.Arrays;
import java.util.Random;

public class ArrayDemo4 {
    static char[] chars = new char[36];

    public static void main(String[] args) {
        // 初始化数组
        init();
        // 从数组中随机抽取4个字符
        char[] code = getRandomCode();
        // 输出验证码
        System.out.println(Arrays.toString(code));

    }

    /**
     * 通过此方法获得一个随机验证码
     */
    private static char[] getRandomCode() {
        Random r = new Random();
        char[] code = new char[4];
        for (int i = 0; i < code.length; i++) {
            code[i] = chars[r.nextInt(chars.length)];
        }
        return code;
    }

    /**
     * 初始化数组
     */
    private static void init() {
        int count = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            chars[count] = i;
            count++;
        }
        for (char i = '0'; i <= '9'; i++) {
            chars[count] = i;
            count++;
        }
        System.out.println(Arrays.toString(chars));
    }
}
