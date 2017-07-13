package custom.CC150.CH16.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: deadend
 * @date: 8:54 PM 1/3/17
 * @version: 1.0
 * @description:
 */


public class Chopstick {
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}
