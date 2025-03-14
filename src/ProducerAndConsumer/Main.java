package ProducerAndConsumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method start");
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
