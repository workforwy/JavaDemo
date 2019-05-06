package algorithm;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 遍历一百万个数字
 */
public class ArrayList100W {
    // 数据长度
    private static int LIST_LENGTH = 1000000;
    // 线程数量
    private static int THREAD_NUMBER = 1000;
    // 每个线程读取的list个数
    private static int SLICE_LENGTH = LIST_LENGTH / THREAD_NUMBER;

    long start;
    long end;
    int numberEquals2;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<MyObject> myObjectArrayList = new ArrayList<>(LIST_LENGTH);
        for (int i = 0; i < LIST_LENGTH; i++) {
            myObjectArrayList.add(new MyObject());
        }
//        fun1(myObjectArrayList);
        fun2(myObjectArrayList);
//        fun3(myObjectArrayList);
//        fun4(myObjectArrayList);
    }

    /**
     * 第一种方法，直接遍历
     *
     * @param myObjectArrayList
     */
    private static void fun1(ArrayList<MyObject> myObjectArrayList) {
        long start = System.currentTimeMillis();
        int numberEquals2 = 0;
        for (int i = 0; i < LIST_LENGTH; i++) {
            if (myObjectArrayList.get(i).type == 2) {
                numberEquals2++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("线程数量1，线性遍历，花费的时间:" + (end - start) + " milliseconds, " + "type等于2的个数有:" + numberEquals2);
    }

    /**
     * 第二种方法，用100个线程来分别跑，用来计数的变量是原子变量
     *
     * @param myObjectArrayList
     * @throws InterruptedException
     */
    private static void fun2(ArrayList<MyObject> myObjectArrayList) throws InterruptedException {
        long start = System.currentTimeMillis();
        AtomicInteger atomicNumberEquals2 = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUMBER);
        for (int i = 0; i < THREAD_NUMBER; i++) {
            final int threadNumber = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = threadNumber * SLICE_LENGTH; j < ((threadNumber + 1) * SLICE_LENGTH); j++) {
                        if (myObjectArrayList.get(j).type == 2) {
                            atomicNumberEquals2.addAndGet(1);
                        }
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        long end = System.currentTimeMillis();
        System.out.println("线程数量:" + THREAD_NUMBER + "(原子变量)花费的时间:" + (end - start) + " milliseconds, " + "type等于2的个数有:" + atomicNumberEquals2.get());
    }

    /**
     * 第三种方法，用100个线程来分别跑，使用数组来计数
     *
     * @param myObjectArrayList
     * @throws InterruptedException
     */
    private static void fun3(ArrayList<MyObject> myObjectArrayList) throws InterruptedException {
        long start = System.currentTimeMillis();

        int numberEquals = getNumberEquals(myObjectArrayList);

        long end = System.currentTimeMillis();
        System.out.println("线程数量:" + THREAD_NUMBER + "(数组存储)花费的时间:" + (end - start) + " milliseconds, " + "type等于2的个数有:" + numberEquals);
    }

    /**
     * 第四种方法，获取本机CPU核心数*2，设置为线程数量
     *
     * @param myObjectArrayList
     * @throws InterruptedException
     */
    private static void fun4(ArrayList<MyObject> myObjectArrayList) throws InterruptedException {
        long start = System.currentTimeMillis();

        THREAD_NUMBER = Runtime.getRuntime().availableProcessors() * 2;
        SLICE_LENGTH = LIST_LENGTH / THREAD_NUMBER;
        int numberEquals = getNumberEquals(myObjectArrayList);

        long end = System.currentTimeMillis();
        System.out.println("线程数量:" + THREAD_NUMBER + "(CPU核心*2)花费的时间:" + (end - start) + " milliseconds, " + "type等于2的个数有:" + numberEquals);
    }

    /**
     * 开启线程池
     *
     * @param myObjectArrayList
     * @return
     * @throws InterruptedException
     */
    private static int getNumberEquals(ArrayList<MyObject> myObjectArrayList) throws InterruptedException {
        int[] result = new int[THREAD_NUMBER];
        int numberEquals = 0;
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUMBER);
        for (int i = 0; i < THREAD_NUMBER; i++) {
            final int threadNumber = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = threadNumber * SLICE_LENGTH; j < ((threadNumber + 1) * SLICE_LENGTH); j++) {
                        if (myObjectArrayList.get(j).type == 2) {
                            result[threadNumber]++;
                        }
                    }
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
        for (int i = 0; i < THREAD_NUMBER; i++) {
            numberEquals += result[i];
        }
        return numberEquals;
    }

    static class MyObject {

        int type;

        MyObject() {
            type = new Random().nextInt(100);
        }
    }
}

