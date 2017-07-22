package leetcode.L384_ShuffleAnArray;


import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ns = reset();
        Random random = new Random();
        for (int i = ns.length - 1; i >= 0; i--) {
            int ix = random.nextInt(i);
            if (ix != i) {
                int t = ns[i];
                ns[i] = ns[ix];
                ns[ix] = t;
            }
        }
        return ns;
    }
}

