package JoinMethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        SharedResources sharedResources = new SharedResources();
        Thread th1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method");
            sharedResources.produce();
        });

        th1.start();
        try {
            System.out.println("Main thread waiting for thread1 to finish now");
            th1.join();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        System.out.println("Main thread finishing its work");
    }
}
