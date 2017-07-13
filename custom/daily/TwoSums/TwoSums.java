package custom.daily.TwoSums;

import java.util.HashMap;

public class TwoSums {

    public int twoSumPairs(int[] nums, int target) {
        int pairs = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            pairs += counter.getOrDefault(target - num, 0);
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        System.out.println(new TwoSums().twoSumPairs(nums, 3));
    }
}
