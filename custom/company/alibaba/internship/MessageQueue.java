package custom.company.alibaba.internship;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class BrokerInfo {
    long availTime;
    int tasksNum;
    long rt;

    public BrokerInfo(long rt) {
        this.rt = rt;
    }

    public void recvTask(long taskTime) {
        tasksNum++;
        availTime = availTime + taskTime;
    }
}

class ThreadInfo {
    long availTime;

    public void sendTask(long rt) {
        availTime += rt;
    }
}

public class MessageQueue {


    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
        final String[] rtList = in.nextLine().split(",");
        final int requestNum = Integer.valueOf(in.nextLine());
        final int threadNum = Integer.valueOf(in.nextLine());
        System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
    }
    /**
     * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
     * @return
     */
    static long doneTime(int maxQps,String[] rtList, int requestNum, int threadNum) {
        final int n = rtList.length;
        int[] rt = new int[n];
        for (int i = 0; i < n; i++) {
            rt[i] = Integer.valueOf(rtList[i]);
        }

        PriorityQueue<BrokerInfo> bheap = new PriorityQueue<>(new Comparator<BrokerInfo>() {
            @Override
            public int compare(BrokerInfo o1, BrokerInfo o2) {
                if (o1.tasksNum < maxQps && o2.tasksNum < maxQps) {
                    return Long.compare(o1.availTime, o2.availTime);
                } else if (o1.tasksNum == maxQps && o2.tasksNum < maxQps) {
                    return 1;
                } else if (o1.tasksNum < maxQps && o2.tasksNum == maxQps) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            bheap.add(new BrokerInfo(1000 / maxQps));
        }

        PriorityQueue<ThreadInfo> theap = new PriorityQueue<>((t1, t2) -> (Long.compare(t1.availTime, t2.availTime)));

        long time = 0L;
        for (int i = 0; i < requestNum; i++) {
            BrokerInfo bi = bheap.poll();
            ThreadInfo ti = theap.poll();
            if (bi.availTime > ti.availTime) {
                ti.availTime = bi.availTime;
            }

            bi.recvTask(1000 / maxQps);
            ti.sendTask(bi.rt);
            time = ti.availTime;
        }
        return time;
    }
}
