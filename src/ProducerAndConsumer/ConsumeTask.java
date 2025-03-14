package ProducerAndConsumer;

public class ConsumeTask implements Runnable{
    SharedResource sharedResource;

    public ConsumeTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread "+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
