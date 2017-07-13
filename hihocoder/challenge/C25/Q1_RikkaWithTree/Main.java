package hihocoder.challenge.C25.Q1_RikkaWithTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 7:P10 PM 12/25/16
 * @version: 1.0
 * @description:
 */


public class Main {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void minTimes(int[] nums, int ix, int sum, int count) {
        if (ix == nums.length) {
            map.put(sum, map.containsKey(sum) ? Math.min(count, map.get(count)) : count);
            return;
        }

        minTimes(nums, ix + 1, sum, count);
        minTimes(nums, ix + 1, sum + nums[ix], count + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.next());
        int[] outdegree = new int[n + 1];

        while (sc.hasNext()) {
            int ix = Integer.valueOf(sc.next());
            outdegree[ix]++;
        }
        Arrays.sort(outdegree);
        int start = 0;
        while (outdegree[start] == 0) {
            start++;
        }

        minTimes(outdegree, start, 0, 0);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                System.out.print(map.get(i));
            } else {
                System.out.print(-1);
            }
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
