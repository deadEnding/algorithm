package custom.CC150.CH16.diningphilosophers;

/**
 * @author: deadend
 * @date: 8:55 PM 1/3/17
 * @version: 1.0
 * @description:
 */


public class Philosopher extends Thread {
    private int bites = 10;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public boolean pickUp() {
        if (!left.pickUp()) {
            return false;
        }

        // 拿不到右手筷子时，放下左手筷子
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    public void chew() {}

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    public void think() {}

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
            think();
        }
    }
}
