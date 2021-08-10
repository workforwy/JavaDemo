package array;

import java.util.Arrays;


/**
 * 给定一个数组，设计一个方法可以向此数组 中添加数据。
 */
class Container {
    /**
     * 定义一个类变量，此变量指向一个 默认长度为3的整数数组
     */
    static int[] array = new int[5];// 0
    /**
     * 定义一个变量，记录数组中有效 元素(添加的元素)的个数
     */
    static int size = 0;

    /**
     * 通过此方法可以不断的向数组中添加数据, 将数据默认方法最后一个有效元素的后面
     **/
    static void add(int number) {
        // 判定数组是否已满
        if (size == array.length) {
            System.out.println("数组已满，进行扩容");
            array = Arrays.copyOf(array, array.length * 2);
        }
        // 没满则继续放数据
        array[size] = number;
        // 有效元素个数加1
        size++;
    }

    /**
     * 写一个方法按指定位置删除某个元素 其中参数pos代表要删除的元素的位置
     */
    public static void delete(int pos) {
        // 1.判定容器是否是空的
        if (size == 0) {
            System.out.println("容器是空的，没你要删除的数据!");
            return;
        }
        // 2.判定位置是否有效
        if (pos < 0 || pos >= size) {
            System.out.println("要删除的元素pos位置无效!");
            return;
        }
        // 3.移动元素(从pos+1位置开始移动，移动几个？)
        /*
         * for(int i=pos;i<size-1;i++){ array[i]=array[i+1]; }
         */
        System.arraycopy(array, pos + 1, array, pos, size - pos - 1);
        // 4.将有效元素个数减一
        size--;
        // 5.将最后一个有效元素的位置设置为0
        array[size] = 0;
    }
}

