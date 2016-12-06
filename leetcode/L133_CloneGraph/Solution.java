package leetcode.L133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:16 AM 12/6/16
 * @version: 1.0
 * @description:
 */

class UndirectedGraphNode {
   int label;
   List<UndirectedGraphNode> neighbors;
   UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }
        return newNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }
}
