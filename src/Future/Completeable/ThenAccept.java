package Future.Completeable;

import java.util.concurrent.*;

public class ThenAccept {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<Void> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread name which executes supplyAsync "+Thread.currentThread().getName());
                    return "Concept and Coding";
                }, poolExecutor)
                .thenAccept((String val) -> System.out.println("All stages completed " + val));


        poolExecutor.shutdown();
    }
}
