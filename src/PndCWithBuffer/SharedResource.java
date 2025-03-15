package PndCWithBuffer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private int bufferSize;
    private Queue<Integer> buffer;
    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        buffer = new LinkedList<>();
    }

    public synchronized void produceItem(int item) throws InterruptedException {
        while (buffer.size() == bufferSize) {
            System.out.println("buffer is full, waiting to items to be consumed");
            wait();
        }
        buffer.add(item);
        System.out.println("Produced item " + item);
        notify();
    }

    public synchronized int consumeItem() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("buffer is empty, waiting for item to be produced");
            wait();
        }

        int item = buffer.poll();
        System.out.println("Consumed item " + item);
        notify();
        return item;
    }
}
