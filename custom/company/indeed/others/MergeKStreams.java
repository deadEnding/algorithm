package custom.company.indeed.others;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKStreams {

    public static List<Integer> findMoreThanKTimes(List<List<Integer>> list, int k) {
        final int n = list.size();

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < n; i++) {
            if (list.get(i) != null && list.get(i).size() > 0) {
                heap.add(new int[] {i, 0, list.get(i).get(0)});
            }
        }

        Integer prev = null;
        int count = 0;
        LinkedList<Integer> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            int[] e = heap.poll();
            if (prev == null || prev != e[2]) {
                if (count > k) {
                    result.add(prev);
                }
                prev = e[2];
                count = 1;
            } else {
                count++;
            }

            List<Integer> l = list.get(e[0]);

            int nextj = e[1] + 1;
            while (nextj < l.size() && l.get(nextj) == e[2]) {
                nextj++;
            }

            if (nextj < l.size()) {
                e[1] = nextj;
                e[2] = l.get(nextj);
                heap.offer(e);
            }
        }

        if (count > k) {
            result.add(prev);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1}, {2,3}, {3,4}};
        List<List<Integer>> list = new LinkedList<>();
        for (int[] ns : nums) {
            List<Integer> l = new LinkedList<>();
            for (int n : ns) {
                l.add(n);
            }
            list.add(l);
        }

        System.out.println(findMoreThanKTimes(list, 1));
    }
}
