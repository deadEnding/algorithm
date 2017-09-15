package custom.company.google.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuhui.zzc on 23/08/2017.
 */
public class MergeNSortedList {

    class Node<T extends Comparable<T>> {
        int i, j;
        T val;

        public Node(int i, int j, T val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public <T extends Comparable<T>> List<T> merge(T[][] lists) {
        PriorityQueue<Node<T>> heap = new PriorityQueue<>(new Comparator<Node<T>>() {
            @Override
            public int compare(Node<T> o1, Node<T> o2) {
                return o1.val.compareTo(o2.val);
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].length > 0) {
                heap.add(new Node(i, 0, lists[i][0]));
            }
        }

        List<T> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            Node<T> node = heap.poll();
            list.add(node.val);
            if (node.j < lists[node.i].length - 1) {
                heap.add(new Node(node.i, node.j + 1, lists[node.i][node.j + 1]));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[][] lists = {{1,3,5}, {2,4,6,8},{7,9}};
        System.out.println(new MergeNSortedList().merge(lists));
    }
}
