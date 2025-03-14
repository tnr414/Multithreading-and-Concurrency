package MonitorLock;

public class MonitorLockExample {
    public synchronized void task1() {
        System.out.println("Inside task 1");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    public void task2() {
        System.out.println("Inside task 2");
        synchronized (this) {
            System.out.println("task2, inside synchronized");
        }
    }

    public void task3() {
        System.out.println("Task 3");
    }
}
