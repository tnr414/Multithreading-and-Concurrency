package Future.Completeable;

import java.util.concurrent.*;

public class SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            return "Task Completed";
        }, poolExecutor);

        System.out.println(asyncTask1.get());
    }
}
