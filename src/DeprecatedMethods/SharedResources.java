package DeprecatedMethods;

public class SharedResources {
    boolean isAvailable = false;

    public synchronized void produce() {
        System.out.println("Lock acquired");
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        System.out.println("Lock released");
    }
}
