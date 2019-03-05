package ch5;

import java.util.concurrent.locks.ReentrantLock;

public class Ch5_9 {
    public static void main(String[] args) {

    }

    public static AutoCloseableReentrantLock getAutoCloseableReentrantLock() {
        AutoCloseableReentrantLock lock = new AutoCloseableReentrantLock();
        lock.lock();

        return lock;
    }
}

class AutoCloseableReentrantLock extends ReentrantLock implements AutoCloseable {
    @Override
    public void close() {
        this.unlock();
    }
}
