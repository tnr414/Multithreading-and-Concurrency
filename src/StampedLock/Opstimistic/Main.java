package StampedLock.Opstimistic;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(sharedResource::producer);
        Thread th2 = new Thread(sharedResource::consumer);

        th1.start();
        th2.start();
    }
}
