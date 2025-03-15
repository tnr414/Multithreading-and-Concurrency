package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void produce() {
        try {
            lock.lock();
            System.out.println("Lock acquired by "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("Lock released by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
