package leetcode.L135_Candy;

/**
 * @author: deadend
 * @date: 12:58 PM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        int sum = count[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                count[i] = count[i + 1] + 1;
            }
            sum += count[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,5,4,1};
        System.out.println(new Solution().candy(ratings));
    }
}
