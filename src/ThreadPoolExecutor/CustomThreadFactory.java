package ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
