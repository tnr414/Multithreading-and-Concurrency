package Future.Completeable;

import java.util.concurrent.*;

public class ThenAcceptAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<CompletableFuture<String>> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name which executes supplyAsync " + Thread.currentThread().getName());
                    return "Concept and";
                }, poolExecutor)
                .thenApplyAsync((String val) -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("All stages completed " + val);
                    return val + "Coding";
                }));

        System.out.println("async task 1 output " + asyncTask1.get());
        poolExecutor.shutdown();
    }
}
