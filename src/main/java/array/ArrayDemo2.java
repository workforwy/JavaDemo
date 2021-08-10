package array;

import java.util.Arrays;

public class ArrayDemo2 {
    public static void main(String[] args) {
        char[] src = { 'A', 'B', 'C' };
        char[] dest = new char[src.length * 2];
        // 访问System类arraycopy方法实现数组的复制
        System.arraycopy(src, // 源数组
                0, // 源数组起始位置
                dest, // 目标数组
                0, // 目标数组开始放的位置
                src.length);// 复制几个
        System.out.println(Arrays.toString(dest));
        // char newChar[]=Arrays.copyOf(src,src.length);
        char newChar[] = copyOf(src, src.length);
        System.out.println(Arrays.toString(newChar));
    }

    public static char[] copyOf(char[] original, int newLength) {
        char[] copy = new char[newLength];
        System.arraycopy(original, 0, copy, 0, original.length <= newLength ? original.length : newLength);
        return copy;
    }
}
