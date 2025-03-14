package ProducerAndConsumer;

public class ProduceTask implements Runnable{
    SharedResource sharedResource;

    public ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            //
        }
        sharedResource.addItem();
    }
}
