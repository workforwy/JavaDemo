package algorithm;

import utils.Log;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序(编写二分法（折半法）搜索函数)
 * 输入为一个已经排好序的整数数组、数组长度以及被查找的数。如果没找到，该函数返回-1；如果找到,返回数组下标。
 */
public class Test1 {

    private static int[] arr;

    static {
        random();// 随机产生有序数组
    }

    public static void main(String[] args) {
        chazhao();// 查找
    }

    private static void chazhao() {
        int n = Integer.parseInt("20");
        int index = binarySearch(arr, n);
        if (index < 0) {
            System.out.println("-1");
        } else {
            System.out.println(n + "在数组中的位置" + index);
        }
    }

    private static int binarySearch(int[] arr, int n) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (n < arr[mid]) {
                hi = mid - 1;
            } else if (n > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -mid;
    }

    private static void random() {
        int len = 10 + new Random().nextInt(11);
        arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        Arrays.sort(arr);
        Log.d(Arrays.toString(arr));
    }
}
