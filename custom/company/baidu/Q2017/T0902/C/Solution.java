package custom.company.baidu.Q2017.T0902.C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NAryNode {

    int key;
    List<NAryNode> child;

    public NAryNode(int key) {
        this.key = key;
        this.child = new ArrayList<>();
    }
}

public class Solution {

    int maxLevelSum(NAryNode familyRoot) {
        if (familyRoot == null) {
            return 0;
        }

        int maxSum = 0;
        Queue<NAryNode> queue = new LinkedList<>();
        queue.offer(familyRoot);
        queue.offer(null);
        int sum = 0;
        while (!queue.isEmpty()) {
            NAryNode p = queue.poll();
            if (p != null) {
                sum += p.key;
                for (NAryNode c : p.child) {
                    queue.offer(c);
                }
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        NAryNode node = new NAryNode(4);
        NAryNode node1 = new NAryNode(2);
        NAryNode node2 = new NAryNode(1);
        node.child.add(node1);
        node.child.add(node2);

        System.out.println(new Solution().maxLevelSum(node));
    }
}
