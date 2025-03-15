package Future.Completeable;

import java.util.concurrent.*;

public class ThenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> "Concept and ", poolExecutor)
                        .thenApply((String val) -> val + "Coding");

        System.out.println(asyncTask1.get());
    }
}

