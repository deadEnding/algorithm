package leetcode.L275_HIndexII;

/**
 * @author: deadend
 * @date: 2:58 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println(new Solution().hIndex(citations));
    }
}
