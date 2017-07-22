package leetcode.again.L575_DistributeCandies;


import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int cd : candies) {
            set.add(cd);
        }

        return Math.min(candies.length / 2, set.size());
    }

    public static void main(String[] args) {
        int[] c = {1,2};
        System.out.println(new Solution().distributeCandies(c));
    }
}
