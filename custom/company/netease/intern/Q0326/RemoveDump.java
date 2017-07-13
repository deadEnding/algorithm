package custom.company.netease.intern.Q0326;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class RemoveDump {

    public static LinkedList<Integer> resolve(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                result.add(0, nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        LinkedList<Integer> result = resolve(nums);
        int count = result.size();
        for (int num : result) {
            System.out.print(num);
            count--;
            if (count != 0) {
                System.out.print(" ");
            }
        }
    }
}
