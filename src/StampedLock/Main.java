package StampedLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(sharedResource::producer);
        Thread th2 = new Thread(sharedResource::producer);
        Thread th3 = new Thread(sharedResource::consumer);

        th1.start();
        th2.start();
        th3.start();

        // out put thread 1 and 2 can work in parallel but thread 3 will have to wait for all locks to be released
        // because it is using exclusive / write lock
    }
}
