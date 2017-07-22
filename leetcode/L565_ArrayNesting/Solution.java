package leetcode.L565_ArrayNesting;

import java.util.Arrays;

public class Solution {
    public int arrayNesting(int[] nums) {
        final int n = nums.length;

        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0;) {
                int v = nums[k];
                nums[k] = -1;
                k = v;
                size++;
            }
            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }
}

class UFSolution {

    class UF {
        int[] parent;
        int[] size;
        int maxSize;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            maxSize = 1;
        }

        public int findRoot(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void union(int pid, int qid) {
            int proot = findRoot(pid);
            int qroot = findRoot(qid);
            if (proot != qroot) {
                parent[proot] = qroot;
                size[qroot] += size[proot];
                maxSize = Math.max(maxSize, size[qroot]);
            }
        }
    }

    public int arrayNesting(int[] nums) {
        final int n = nums.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            uf.union(i, nums[i]);
        }
        return uf.maxSize;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(new Solution().arrayNesting(nums));
    }
}
