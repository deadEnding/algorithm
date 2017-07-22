package leetcode.again.L621_TaskScheduler;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char task : tasks) {
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        heap.addAll(counter.values());

        int count = 0;
        while (!heap.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int m = Math.min(n + 1, heap.size());
            for (int i = 0; i < m; i++) {
                int cnt = heap.poll() - 1;
                if (cnt > 0) {
                    tmp.add(cnt);
                }
            }

            heap.addAll(tmp);
            count += heap.isEmpty() ? m : (n + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(new Solution().leastInterval(tasks, 1));
    }
}
