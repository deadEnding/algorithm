package leetcode.L120_Triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:17 PM 11/21/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {{ add(1); }});
        triangle.add(new ArrayList<Integer>() {{ add(2); add(3); }});
        System.out.println(new Solution().minimumTotal(triangle));
    }
}

class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size();
        int[] row = new int[n];

        row[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int left = j == 0 ? Integer.MAX_VALUE : row[j - 1];
                int right = j == i ? Integer.MAX_VALUE : row[j];
                row[j] = triangle.get(i).get(j) + Math.min(left, right);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : row) {
            min = Math.min(min, i);
        }
        return min;
    }
}
