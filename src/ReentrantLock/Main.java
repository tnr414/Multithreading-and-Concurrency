package ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread th1 = new Thread(sharedResource::produce);
        Thread th2 = new Thread(sharedResource::produce);

        th1.start();
        th2.start();
    }
}
