package WayToCreateThread;

public class Multithreading1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Code executed by: "+Thread.currentThread().getName());
    }
}
