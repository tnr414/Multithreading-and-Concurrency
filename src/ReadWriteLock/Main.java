package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            sharedResource.producer(lock);
        });

        SharedResource sharedResource1 = new SharedResource();

        Thread th2 = new Thread(() -> {
            sharedResource1.producer(lock);
        });

        SharedResource sharedResource2 = new SharedResource();

        Thread th3 = new Thread(() -> {
            sharedResource2.consumer(lock);
        });

        th1.start();
        th2.start();
        th3.start();
        // out put thread 1 and 2 can work in parallel but thread 3 will have to wait for all locks to be released
        // because it is using exclusive / write lock
    }
}
