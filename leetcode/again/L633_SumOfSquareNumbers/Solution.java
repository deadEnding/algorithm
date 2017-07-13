package leetcode.again.L633_SumOfSquareNumbers;


import java.util.HashSet;

public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        int l = 0, r = (int) Math.sqrt(c) + 1;
        while (l <= r) {
            int sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }
}

class BasicSolution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> squareNums = new HashSet<>();
        for (int i = 0; (long)i * i <= c; i++) {
            squareNums.add(i * i);
        }

        for (int i = 0; (long)i * i * 2 <= c; i++) {
            if (squareNums.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(2));
    }
}
