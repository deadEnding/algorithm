package leetcode.L506_RelativeRanks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: deadend
 * @date: 2:08 PM 2/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        final int n = nums.length;
        String[] rank = new String[n];
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = i;
            list[i][1] = nums[i];
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            switch (i) {
                case 0:
                    rank[list[i][0]] = "Gold Medal";
                    break;
                case 1:
                    rank[list[i][0]] = "Silver Medal";
                    break;
                case 2:
                    rank[list[i][0]] = "Bronze Medal";
                    break;
                default:
                    rank[list[i][0]] = String.valueOf(i + 1);
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2,1};
        String[] rank = new Solution().findRelativeRanks(nums);
        for (String r : rank) {
            System.out.print(r + ",");
        }
    }
}
