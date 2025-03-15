package SemaphoreLock;


import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = true;
    Semaphore lock = new Semaphore(2);

    public void producer() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by "+Thread.currentThread().getName());
            isAvailable = true;

            Thread.sleep(4000);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock released by "+Thread.currentThread().getName());
            lock.release();
        }
    }
}