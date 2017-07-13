package custom.CC150.CH17;

/**
 * @author: deadend
 * @date: 4:52 PM 1/4/17
 * @version: 1.0
 * @description: 二叉搜索树转化成双向链表
 */

class BiNode {
    int val;
    BiNode node1, node2;

    public BiNode(int val) {
        this.val = val;
    }
}

public class BST2DoublyLinkedList {

    private BiNode head;
    private BiNode last;

    public void convert(BiNode root) {
        if (root == null) {
            return;
        }

        convert(root.node1);
        if (last != null) {
            last.node2 = root;
            root.node1 = last;
        } else {
            head = root;
        }
        last = root;
        convert(root.node2);
    }
}
