package leetcode.L413_ArithmeticSlices;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 5:01 PM 12/21/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        for (int i = 2, curr = 0; i < A.length; i++) {
            if (2 * A[i - 1] == A[i - 2] + A[i]) {
                curr++;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }
}

class BasicSolution {
    private int getNumber(HashMap<Integer, Integer> mem, int target) {
        if (target <= 3) {
            return target == 3 ? 1 : 0;
        }

        if (!mem.containsKey(target)) {
            mem.put(target, getNumber(mem, target - 1) + target - 2);
        }
        return mem.get(target);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int sum = 0;
        HashMap<Integer, Integer> mem = new HashMap<>();
        for (int i = 1; i < A.length - 1; i++) {
            int count = 0;
            while (i < A.length - 1 && 2 * A[i] == A[i - 1] + A[i + 1]) {
                count++;
                i++;
            }
            sum += getNumber(mem, count + 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1,2, 3,4};
        System.out.println(new Solution().numberOfArithmeticSlices(A));
    }
}
