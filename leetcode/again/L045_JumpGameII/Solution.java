package leetcode.again.L045_JumpGameII;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:18 AM 3/4/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int jump(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int step = 0;
        for (int i = 0, levelEnd = 0, nextLevelEnd = 0; i <= levelEnd; i++) {
            nextLevelEnd = Math.max(nextLevelEnd, i + nums[i]);
            if (nextLevelEnd >= n - 1) {
                return step + 1;
            }

            if (i == levelEnd) {
                levelEnd = nextLevelEnd;
                step++;
            }
        }
        return -1;
    }
}

class BasicBFSSolution {
    public int jump(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(null);
        int visited = 0;
        int step = 0;
        while (!queue.isEmpty()) {
            Integer ix = queue.poll();
            if (ix == null) {
                step++;
                queue.offer(null);
            } else if (ix >= nums.length - 1) {
                return step;
            } else {
                for (int i = Math.max(ix + 1, visited + 1); i <= ix + nums[ix]; i++) {
                    queue.offer(i);
                }
                visited = Math.max(visited, ix + nums[ix]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}


class TimeoutSolution {
    public int jump(int[] nums) {
        final int n = nums.length;
        int[] min = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = -1;
            for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                if (min[j] != -1 && (min[i] == -1 || min[j] + 1 < min[i])) {
                    min[i] = min[j] + 1;
                }
            }
            System.out.println(nums[i] + " " + min[i]);
        }
        return min[0];
    }
}
