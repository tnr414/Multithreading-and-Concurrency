package WayToCreateThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Going inside main method: "+Thread.currentThread().getName());
        // 1st way to create thread
        Multithreading1 runnableObj = new Multithreading1();
        Thread thread1 = new Thread(runnableObj);
        thread1.start();

        // 2nd way to create thread
        Multithreading2 thread2 = new Multithreading2();
        thread2.start();

        System.out.println("Finish main method "+Thread.currentThread().getName());
    }
}
