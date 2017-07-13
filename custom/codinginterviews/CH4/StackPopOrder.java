package custom.codinginterviews.CH4;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:45 PM 2/6/17
 * @version: 1.0
 * @description: 给定入栈序列，判断出栈序列是否合法
 */


public class StackPopOrder {

    public boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length != pop.length) {
            return false;
        }

        final int n = push.length;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < n; i++) {
            while (stack.isEmpty() || stack.peek() != pop[i]) {
                if (j == n) {
                    return false;
                }
                stack.push(push[j++]);
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(new StackPopOrder().isPopOrder(push, pop));
    }
}
