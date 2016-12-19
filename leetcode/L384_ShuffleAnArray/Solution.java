package leetcode.L384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: deadend
 * @date: 9:30 AM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = arr.length - 1; i > 0; i--) {
            int r = random.nextInt(i + 1);
            int tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
