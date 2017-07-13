package custom.company.baidu.Q2017.Q2;

import java.util.concurrent.locks.Lock;

public class ConvenientLock {

    private Lock lock;

    public ConvenientLock(Lock lock) {
        this.lock = lock;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
