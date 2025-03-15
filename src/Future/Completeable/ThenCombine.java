package Future.Completeable;

import java.util.concurrent.*;

public class ThenCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> "k");

        CompletableFuture<String> combineFutureObj = asyncTask1.thenCombine(
          asyncTask2, (Integer val1, String val2) -> val1 + val2
        );

        System.out.println("After combining value is " + combineFutureObj.get());

        poolExecutor.shutdown();
    }
}
