package thread;

import utils.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadLocal {

    // 总的请求个数
    public static final int requestTotal = 1000;

    // 同一时刻最大的并发线程的个数
    public static final int concurrentThreadNum = 20;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World!");

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        Semaphore semaphore = new Semaphore(concurrentThreadNum);
        for (int i = 0; i < requestTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    Log.d("result:{}.", "");
                    semaphore.release();
                } catch (InterruptedException e) {
                    Log.d("exception", e.toString());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        Log.d("请求完成");
    }
}
