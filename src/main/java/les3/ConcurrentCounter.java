package les3;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCounter {
    private volatile int count;
    private final ReentrantLock lock;

    public ConcurrentCounter() {
        lock = new ReentrantLock();
    }

    public void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    public void decrement() {
        lock.lock();
        count--;
        lock.unlock();

    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCounter counter = new ConcurrentCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.decrement();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }
}
