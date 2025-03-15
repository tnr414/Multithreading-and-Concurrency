package StampedLock.Opstimistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic lock");
            a = 11;
            if (lock.validate(stamp)) {
                System.out.println("Updated a value successfully");
            } else {
                System.out.println("Rollback of work");
                a = 10;
            }

            // optimistic read is not a lock so no need of releasing lock
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            a = 9;
        } finally {
            System.out.println("Write lock released by " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}


