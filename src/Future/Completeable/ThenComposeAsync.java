package Future.Completeable;

import java.util.concurrent.*;

public class ThenComposeAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name which executes supplyAsync "+Thread.currentThread().getName());
                    return "Concept and ";
                }, poolExecutor)
                .thenComposeAsync((String val) -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name which executes thenComposeAsync " + Thread.currentThread().getName());
                    return val + "Coding";
                }));

        System.out.println("Thread name for after CF "+Thread.currentThread().getName());
        System.out.println(asyncTask1.get());
    }
}
