package leetcode.again.L561_ArrayPartitionI;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[2 * i];
        }
        return sum;
    }
}
