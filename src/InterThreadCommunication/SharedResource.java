package InterThreadCommunication;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = true;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    // lock level condition not thread level condition

    public void producer() {
        try {
            lock.lock();
            System.out.println("Lock acquired by "+Thread.currentThread().getName());
            if (isAvailable) {
                System.out.println("Waiting");
                condition.await();
            }

            isAvailable = true;
            condition.signal();
        } catch (Exception e) {
            //
        }
        finally {
            System.out.println("Lock released by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}