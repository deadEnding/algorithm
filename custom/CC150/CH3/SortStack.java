package custom.CC150.CH3;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:29 PM 12/27/16
 * @version: 1.0
 * @description: [P143] 3.6 最多使用一个栈的空间对原栈排序
 */


public class SortStack {

    public static LinkedList<Integer> sort(LinkedList<Integer> stack) {
        LinkedList<Integer> sorted = new LinkedList<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!sorted.isEmpty() && tmp < sorted.peek()) {
                stack.push(sorted.pop());
            }
            sorted.push(tmp);
        }
        return sorted;
    }

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            stack.push(new java.util.Random().nextInt(1000));
        }
        System.out.println(stack.toString());
        System.out.println(sort(stack).toString());
    }
}
