package leetcode.L386_LexicographicalNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:12 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<Integer> result = new LinkedList<>();

    private void lexicalOrder(int ix, int n) {
        if (ix > n) {
            return;
        }

        result.add(ix);
        for (int i = 0; i < 10; i++) {
            lexicalOrder(ix * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            lexicalOrder(i, n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(1).toString());
    }
}


class ItertiveSolution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
