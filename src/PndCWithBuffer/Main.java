package PndCWithBuffer;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(3);
        Thread produceThread = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    resource.produceItem(i);
                }
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        });

        Thread consumeThread = new Thread(() -> {
            try {
                for (int i = 0; i < 6; i++) {
                    resource.consumeItem();
                }
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        });

        produceThread.start();
        consumeThread.start();
    }
}
