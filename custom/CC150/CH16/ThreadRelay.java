package custom.CC150.CH16;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author: deadend
 * @date: 11:13 AM 1/4/17
 * @version: 1.0
 * @description: 线程接力，将ThreadRelay实例传递给3个线程，分别调用first、second、third方法
 */


public class ThreadRelay {
    private Semaphore sem1, sem2, sem3;

    public ThreadRelay() throws InterruptedException {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        sem3 = new Semaphore(1);

        sem1.acquire();
        sem2.acquire();
        sem3.acquire();
    }

    public void first() {
        System.out.println("Running first ...");
        sem1.release();
    }

    public void second() throws InterruptedException {
        sem1.acquire();
        System.out.println("Running second ...");
        sem1.release();
        sem2.release();
    }

    public void third() throws InterruptedException {
        sem2.acquire();
        System.out.println("Running third ...");
        sem2.release();
        sem3.release();
    }
}

class CDLThreadRelay {
    private CountDownLatch cdl1, cdl2;

    public CDLThreadRelay() {
        cdl1 = new CountDownLatch(1);
        cdl2 = new CountDownLatch(1);
    }

    public void first() {
        System.out.println("Running first ...");
        cdl1.countDown();
    }

    public void second() throws InterruptedException {
        cdl1.await();
        System.out.println("Running second ...");
        cdl2.countDown();
    }

    public void third() throws InterruptedException {
        cdl2.await();
        System.out.println("Running third ...");
    }
}
