package leetcode.again.L487_MaxConsecutiveOnesII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 9:39 PM 3/14/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int lastZero = -1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = lastZero + 1;
                lastZero = r;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}

class KSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, k = 1;
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroIndex.offer(r);
            }

            if (zeroIndex.size() > k) {
                l = zeroIndex.poll() + 1;
            }

            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}

class BasicSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] zeroIndex = {-1, 0, 0};
        int ix = 0;
        int max = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                zeroIndex[(++ix) % 3] = i;
            }

            if (ix == 1) {
                max = Math.max(max, zeroIndex[1] - zeroIndex[0] - 1);
            } else {
                max = Math.max(max, zeroIndex[ix % 3] - zeroIndex[(ix + 1) % 3] - 1);
            }
        }
        return max;
    }
}


class TrivialSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        ArrayList<Integer> compress = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 1;
                while (i + 1 < nums.length && nums[i + 1] == 1) {
                    i++;
                    count++;
                }
                compress.add(count);
            } else {
                compress.add(0);
            }
        }

        int max = 0;
        for (int i = 0; i < compress.size(); i++) {
            if (compress.get(i) > 0) {
                max = Math.max(max, compress.get(i));
            } else {
                int front = i - 1 >= 0 ? compress.get(i - 1) : 0;
                int rear = i + 1 < compress.size() ? compress.get(i + 1) : 0;
                max = Math.max(max, front + rear + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }
}
