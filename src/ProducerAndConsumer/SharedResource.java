package ProducerAndConsumer;

public class SharedResource {
    boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName()
         + " and invoking all thread which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume method invoked by "+Thread.currentThread().getName());

        while (!itemAvailable) {
            try {
                System.out.println("Thread "+Thread.currentThread().getName()+" is waiting now");
                wait();
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
        }

        System.out.println("Item consumed by "+Thread.currentThread().getName());
        itemAvailable = false;
    }
}
