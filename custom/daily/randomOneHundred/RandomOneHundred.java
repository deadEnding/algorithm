package custom.daily.randomOneHundred;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: deadend
 * @date: 11:57 AM 3/7/17
 * @version: 1.0
 * @description: 随机生成 [0, 10000] 范围内的100个不重复的随机数
 */


public class RandomOneHundred {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public int[] generate(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        Random rand = new Random();
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, rand.nextInt(i + 1));
        }
        return nums;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] nums = new int[n];
        RandomOneHundred r = new RandomOneHundred();
        for (int i = 0; i < 1000; i++) {
            int[] t = r.generate(100000);
            for (int j = 0; j < n; j++) {
                nums[j] += t[j];
            }
        }

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
