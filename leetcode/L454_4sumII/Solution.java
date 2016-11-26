package leetcode.L454_4sumII;


import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:01 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        final int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = A[i] + B[j];
                map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = -(C[i] + D[j]);
                if (map.containsKey(s)) {
                    count += map.get(s);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(new Solution().fourSumCount(A, B, C, D));
    }
}
