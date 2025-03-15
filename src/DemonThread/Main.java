package DemonThread;

import DemonThread.SharedResources;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        SharedResources sharedResources = new SharedResources();
        Thread th1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method");
            sharedResources.produce();
        });

        th1.setDaemon(true);
        th1.start();

        System.out.println("Main thread finishing its work");
        // will never see lock release in output because th1 ends as main thread ends
    }
}
