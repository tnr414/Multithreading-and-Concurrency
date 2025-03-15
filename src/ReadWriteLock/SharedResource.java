package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("Read lock released by "+Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            System.out.println("Write lock released by "+Thread.currentThread().getName());
            lock.writeLock().lock();
        }
    }

}
