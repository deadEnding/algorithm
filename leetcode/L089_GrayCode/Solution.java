package leetcode.L089_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:38 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> grayCode(int n) {
        final int size = 1 << n;
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BasicSolution().grayCode(3).toString());
    }
}

class BasicSolution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + inc);
            }
        }
        return result;
    }
}

