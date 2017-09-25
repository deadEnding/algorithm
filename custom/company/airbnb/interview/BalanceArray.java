package custom.company.airbnb.interview;

import java.util.HashMap;

public class BalanceArray {

    public int countBalanceSubArray(int[] nums, boolean canBeSingle) {
        return canBeSingle ? countBalanceSubArrayWithSingle(nums) : countBalanceSubArrayWithoutSingle(nums);
    }

    public int countBalanceSubArrayWithSingle(int[] nums) {
        final int n = nums.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> left = new HashMap<>();
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                left.put(sum, left.getOrDefault(sum, 0) + 1);
            }

            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                count += left.getOrDefault(sum, 0);
            }
        }

        return count;
    }

    public int countBalanceSubArrayWithoutSingle(int[] nums) {
        final int n = nums.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> left = new HashMap<>();
            int sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                sum += nums[j];
                left.put(sum, left.getOrDefault(sum, 0) + 1);
            }

            sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                count += left.getOrDefault(sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,-2};
        System.out.println(new BalanceArray().countBalanceSubArray(nums, false));
    }
}
