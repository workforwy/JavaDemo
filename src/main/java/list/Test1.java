package list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        listTest();
    }

    /**
     * 数组集合操作
     */
    private static void listTest() {
        String[] str = new String[]{"1", "2", "3", "4"};
        List<String> list = new ArrayList<String>();
        if (Collections.addAll(list, str)) {
            list.add(2, "999");
        }

        String[] newStr = list.toArray(new String[1]);
        System.out.println(Arrays.deepToString(newStr));

        String[][] arrayOfArray = new String[][]{newStr, newStr};
        System.out.println(Arrays.deepToString(arrayOfArray));
    }

    // 单次读写
    public void one() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("");
            int temp = fis.read();
            while (temp != -1) {
                System.out.print(temp);
                temp = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 多次读写
    public void most() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("");
            byte[] bytes = new byte[1024];
            int result = fis.read(bytes);
            while (result != -1) {
                String temp = new String(bytes, 0, result);
                result = fis.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
