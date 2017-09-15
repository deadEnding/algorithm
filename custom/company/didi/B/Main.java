package custom.company.didi.B;

import java.util.Scanner;

public class Main {

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= pivot) {
                r--;
            }
            nums[l] = nums[r];

            while (l < r && nums[l] > pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private static int findKth(int[] nums, int s, int e, int kix) {
        int ix = partition(nums, s, e);
        if (ix == kix) {
            return nums[ix];
        } else if (ix < kix) {
            return findKth(nums, ix + 1, e, kix);
        } else {
            return findKth(nums, s, ix - 1, kix);
        }
    }

    public static int findKth(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        int k = Integer.valueOf(in.nextLine());

        String[] ns = numStr.split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(ns[i]);
        }

        System.out.println(findKth(nums, k));
    }
}
