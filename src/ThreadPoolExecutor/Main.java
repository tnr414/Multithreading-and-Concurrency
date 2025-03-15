package ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), new CustomThreadFactory(),
                new CustomRejectedHandler());

        poolExecutor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 25; i++) {
            poolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name: "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
                }
            });
        }

        poolExecutor.shutdown();
    }
}
