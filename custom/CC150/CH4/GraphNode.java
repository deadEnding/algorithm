package custom.CC150.CH4;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:48 PM 12/27/16
 * @version: 1.0
 * @description: 图结点
 */


public class GraphNode {
    int val;
    LinkedList<GraphNode> adjacent;

    public GraphNode(int val) {
        this.val = val;
    }
}
