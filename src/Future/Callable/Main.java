package Future.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // Use case 1 - runnable
        Future<?> futureObj1 = poolExecutor.submit(() -> {
            System.out.println("Task 1 with runnable");
        });

        try {
            Object object = futureObj1.get();
            System.out.println(object == null);

        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
        }

        // use case 2 - runnable with return object
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
            output.add(100);
            System.out.println("Task2 with Runnable and return object");
        }, output);

        try {
            List<Integer> outputFromFutureObject2 = futureObj2.get();
            System.out.println(outputFromFutureObject2.getFirst());

        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
        }

        // use case 3 - callable (clean way than runnable with return)
        Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
            System.out.println("Task 3 with callable");
            List<Integer> list = new ArrayList<>();
            list.add(200);
            return list;
        });

        try {
            List<Integer> outputFromFutureObject3 = futureObj3.get();
            System.out.println(outputFromFutureObject3.getFirst());

        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
        }

    }
}
