package custom.company.baidu.Q20170927.B;

import java.util.Random;

public class Task extends Thread {

    private int taskPriority;
    private PriorityScheduler scheduler;
    private Random random = new Random();

    public Task(PriorityScheduler scheduler, int priority) {
        this.scheduler = scheduler;
        this.taskPriority = priority;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    // 是否可执行
    public boolean executable() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(random.nextInt(1000) + 1000);
            return random.nextInt(2) == 0;
        }
    }

    // 执行内容
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(random.nextInt(1000) + 1000);
                int i = random.nextInt(101);
                System.out.println(i);
                taskPriority = i % scheduler.getN();
                scheduler.submitTask(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
