package array;

import java.util.Arrays;

// 测试
public class ArrayDemo3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Container.add(i);
        }
        System.out.println(Container.size);
        System.out.println(Arrays.toString(Container.array));
        Container.delete(3);
        System.out.println(Arrays.toString(Container.array));

    }
}

