package leetcode.again.L128_LongestConsecutiveSequence;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 4:40 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, new int[] {n - 1, n + 1});
        }

        int max = 0;
        for (int key : map.keySet()) {
            int[] range = map.get(key);
            if (map.containsKey(range[0])) {
                map.get(range[0])[1] = range[1];   // 扩展其他区间，扩展自己区间会有问题
            }
            if (map.containsKey(range[1])) {
                map.get(range[1])[0] = range[0];   // 扩展其他区间，扩展自己区间会有问题
            }
            max = Math.max(max, range[1] - range[0] - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-3,1,-2,-1,0};
        System.out.println(new UnionFindSolution().longestConsecutive(nums));
    }
}

class UnionFindSolution {

    class UF {

        private int[] parent;
        private int[] size;
        private int maxSize;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            maxSize = n > 0 ? 1 : 0;
        }

        public int findRoot(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void union(int pid, int qid) {
            int pRoot = findRoot(pid);
            int qRoot = findRoot(qid);
            if (pRoot == qRoot) {
                return;
            }
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
            maxSize = Math.max(maxSize, size[qRoot]);
        }

        public int getMaxSize() {
            return maxSize;
        }
    }

    public int longestConsecutive(int[] nums) {
        final int n = nums.length;

        UF uf = new UF(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }

            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }

            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
        }
        return uf.getMaxSize();
    }
}