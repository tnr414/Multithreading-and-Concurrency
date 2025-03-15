package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.readLock();
        try {
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("Read lock released by " + Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("Write lock released by " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}


