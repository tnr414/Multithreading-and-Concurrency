package Future.Runnable;

import java.util.concurrent.*;

/*
    future object have mainly 5 function
    1. cancel(boolean mayInterruptIfRunning)
    2. isCancelled()
    3. isDone()
    4. get()
    5. get(long time, TimeUnit unit)
*/

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("This is the task, that thread will execture");
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        });

        System.out.println("is Done "+ futureObj.isDone());
        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout exception");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            futureObj.get();
        } catch (Exception e) {
            //
        }

        System.out.println("is done " + futureObj.isDone());
        System.out.println("is cancelled " + futureObj.isCancelled());
    }
}
