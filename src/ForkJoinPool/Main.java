package ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new ComputeSumTask(0, 100));

        try {
            System.out.println("Output " + future.get());
        } catch (Exception e) {
            //
        }
    }
}
