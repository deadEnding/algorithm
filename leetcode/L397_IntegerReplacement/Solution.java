package leetcode.L397_IntegerReplacement;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:04 AM 12/20/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int integerReplacement(int n) {
        int c = 0;
        long num = n;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else if (num == 3 || ((num >> 1) & 1) == 0) {
                num--;
            } else {
                num++;
            }
            c++;
        }
        return c;
    }
}

class BFSSolution {
    public int integerReplacement(int n) {
        int steps = 0;
        LinkedList<Long> queue = new LinkedList<>();

        queue.offer((long) n);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Long x = queue.poll();
            if (x == null) {
                steps++;
                queue.offer(null);
                continue;
            }

            if (x == 1) {
                return steps;
            } else if (x % 2 == 0) {
                queue.offer(x / 2);
            } else {
                queue.offer(x + 1);
                queue.offer(x - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(Integer.MAX_VALUE));
    }
}
