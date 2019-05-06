package thread;

import java.util.concurrent.*;

/**
 * 线程池
 */

public class Test2 {
    public static void main(String[] args) {
        ExecutorServiceTest();
    }

    private static void ScheduledExecutorService() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        service.schedule(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "延迟三秒执行");
            }
        }, 3, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "延迟三秒后每隔2秒执行");
            }
        }, 3, 2, TimeUnit.SECONDS);
    }

    public static void ExecutorServiceTest() {
        ExecutorService service = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        service.execute(new Runnable() {
            public void run() {
                System.out.println("execute方式");
            }
        });

        Future<Integer> future = service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("submit方式");
                return 2;
            }
        });
        try {
            Integer number = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }
}
