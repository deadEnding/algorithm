package leetcode.again.L398_RandomPickIndex;


import java.util.Random;

public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int ix = -1;
        for (int i = 0, cnt = 1; i < nums.length; i++) {
            if (nums[i] == target && random.nextInt(cnt++) == 0) {
                ix = i;
            }
        }

        return ix;
    }
}
