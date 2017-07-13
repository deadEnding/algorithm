package custom.CC150.CH9;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:53 PM 12/29/16
 * @version: 1.0
 * @description:
 */


public class Permutations {

    private ArrayList<int[]> perms = new ArrayList<>();

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void getPermutations(int[] nums, int ix) {
        if (ix == nums.length) {
            perms.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int i = ix; i < nums.length; i++) {
            swap(nums, ix, i);
            getPermutations(nums, ix + 1);
            swap(nums, ix, i);
        }
    }

    public ArrayList<int[]> getPermutations(int[] nums) {
        getPermutations(nums, 0);
        return perms;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        for (int[] n : new Permutations().getPermutations(nums)) {
            for (int i : n) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
