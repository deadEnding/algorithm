package custom.company.baidu.Q20170927.B;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PriorityScheduler {

    private int n;
    private LinkedBlockingQueue<Task>[] queues;
    private ExecutorService[] checkPools;
    private ExecutorService executePool;
    private boolean running = true;

    public PriorityScheduler(int n) {
        this.n = n;
        queues = new LinkedBlockingQueue[n];
        checkPools = new ExecutorService[n];
        executePool = Executors.newCachedThreadPool();

        for (int i = 0; i < n; i++) {
            queues[i] = new LinkedBlockingQueue<>(1000);
            checkPools[i] = Executors.newCachedThreadPool();
            for (int c = 0; c < 2000; c++) {
                long duration = i == n - 1 ? 60000 : 60000 * 3;
                checkPools[i].submit(new CheckTaskExecutableThread(queues[i], duration));
            }
        }
    }

    // 优先级等级数
    public int getN() {
        return n;
    }

    // 提交任务
    public boolean submitTask(Task task) {
        int taskPriority = task.getTaskPriority();
        if (queues[taskPriority].size() < 1000) {   // 队列未满
            queues[taskPriority].offer(task);
            return true;
        }
        return false;
    }

    // 删除任务
    public void deleteTask(Task task) {
        int taskPriority = task.getTaskPriority();
        queues[taskPriority].remove(task);
    }

    // 判断任务是否可执行，可执行的话就将任务放入执行线程，否则放回原队列
    public class CheckTaskExecutableThread extends Thread {
        private LinkedBlockingQueue<Task> queue;
        private long sleepDuration;

        public CheckTaskExecutableThread(LinkedBlockingQueue<Task> queue, long duration) {
            this.queue = queue;
            this.sleepDuration = duration;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    Task task = queue.take();
                    if (task.executable()) {
                        executePool.submit(task);
                    } else {
                        queue.offer(task);
                    }
                    Thread.sleep(sleepDuration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
