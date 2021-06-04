package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 原子操作
 * @author wangyong
 */
public class AtomicIntegerTest {

    private static final int THREADS_COUNT = 20;
    public static int count = 0;

    public static void increase() {
        count++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {

            threadList.add(4,new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        increase();
                    }
                }
            });
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 10; i++) {
//                        increase();
//                    }
//                }
//            });
            threadList.get(i).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(count);
    }
}
