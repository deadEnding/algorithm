package leetcode.again.L089_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 12:48 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + inc);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(0));
    }
}
