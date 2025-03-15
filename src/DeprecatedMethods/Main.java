package DeprecatedMethods;

import PndCWithBuffer.SharedResource;

public class Main {
    // example of deprecated methods are
    // 1. Stop
    // 2. Resume
    // 3. Suspend
    // Reason - they can lead to deadlock

    // we will see example of suspend leading deadlock

    public static void main(String[] args) {
        SharedResources sharedResource = new SharedResources();
        System.out.println("Main thread started");

        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 call produce method");
            sharedResource.produce();
        });

        Thread th2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
            System.out.println("Thread2 calling produce method");
            // because of deadlock thread2 will never be able to call
            sharedResource.produce();
        });

        th1.start();
        th2.start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
//                throw new RuntimeException(e);
        }

        System.out.println("Thread1 is suspended");
//        th1.suspend();

        System.out.println("Main thread is finishing its work");
    }
}
