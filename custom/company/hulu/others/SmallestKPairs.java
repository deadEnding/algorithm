package custom.company.hulu.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 两个数组求两数之和最小的k对
 *
 * http://www.cnblogs.com/weixliu/p/3779288.html
 */

public class SmallestKPairs {

    public List<Integer> smallestKPairs(int[] a, int[] b, int k) {
        final int m = a.length;
        final int n = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> heap = new PriorityQueue<>((i1, i2) -> (i1[0] - i2[0]));

        for (int i = 0; i < Math.min(m, k); i++) {
            heap.offer(new int[] {a[i] + b[0], i, 0});
        }

        List<Integer> result = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            int[] p = heap.poll();
            if (result.size() == 0 || p[0] != result.get(result.size() - 1)) {  // 去重
                result.add(p[0]);
            }
            if (p[2] + 1 < n) {
                heap.offer(new int[] {a[p[1]] + b[p[2] + 1], p[1], p[2] + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3};
        int k = 100;
        System.out.println(new SmallestKPairs().smallestKPairs(a, b, k));
    }
}
