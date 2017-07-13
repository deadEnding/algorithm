package custom.codinginterviews.CH6;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:04 AM 2/7/17
 * @version: 1.0
 * @description: 求所有和为sum的连续整数序列（至少2元素）
 */


public class ContinuousSum {

    public List<List<Integer>> findContinuousSequence(int sum) {
        LinkedList<Integer> seq = new LinkedList<>();
        seq.addLast(1);
        seq.addLast(2);
        int s = 3;
        List<List<Integer>> result = new LinkedList<>();
        while (seq.size() > 1) {
            if (s >= sum) {
                if (s == sum) {
                    result.add(new LinkedList<>(seq));
                }
                s -= seq.removeFirst();
            } else {
                seq.addLast(seq.getLast() + 1);
                s += seq.getLast();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ContinuousSum().findContinuousSequence(15);
        for (List<Integer> l : result) {
            for (int x : l) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
