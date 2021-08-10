package array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组内容复制到一个长度 一样的数组中。
 */
public class ArrayDemo1 {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};
        int newArray01[] = copy(array);
        System.out.println(Arrays.toString(newArray01));
        int newArray02[] = new int[array.length];
        // copy(array,newArray02);
        // System.out.println(Arrays.toString(newArray01));
        copy(array, 1, newArray02, 3, 2);
        System.out.println(Arrays.toString(newArray02));

    }

    static int[] copy(int array[]) {
        int cpArray[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cpArray[i] = array[i];
        }
        return cpArray;
    }

    static void copy(int src[], int dest[]) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    static void copy(int src[], int srcPos, int[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos] = src[srcPos];
            srcPos++;
            destPos++;
        }
    }
}
