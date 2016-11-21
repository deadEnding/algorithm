package leetcode.L118_PascalsTriangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:16 PM 11/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }

        result.add(new ArrayList<Integer>(1) {{ add(1);}});
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(result.size() - 1);
            List<Integer> curr = new ArrayList<>(i + 1);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().generate(6);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
