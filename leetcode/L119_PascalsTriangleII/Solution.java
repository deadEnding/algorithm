package leetcode.L119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:39 PM 11/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(i, 1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().getRow(3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
