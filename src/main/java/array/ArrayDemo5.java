package array;

import java.util.Arrays;

public class ArrayDemo5 {
    public static void main(String[] args) {
        int n = 3;
        // 数组中要存放九宫格中的数据
        int a[][] = new int[n][n];
        // 确定第一个数的位置
        int row = 0;// 行
        int col = n / 2;// 列
        // i 为要填写的数据
        for (int i = 1; i <= n * n; i++) {
            // 填数
            a[row][col] = i;
            // 确定下一个数位置
            row--;
            col++;
            // 判定是否越界或被占用
            // 1)行越界，列不越界
            if (row < 0 && col < n) {
                row = n - 1;
            }
            // 2)列越界，行不越界
            else if (col == n && row >= 0) {
                col = 0;
            }
            // 3)行列都越界
            else if (row < 0 && col == n) {
                col--;
                row += 2;
            }
            // 4)位置被占用
            else if (a[row][col] != 0) {
                col--;
                row += 2;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]) + "\t");
        }
    }
}
