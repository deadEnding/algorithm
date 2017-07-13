package leetcode.again.L133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:56 PM 3/2/17
 * @version: 1.0
 * @description:
 */


class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}


public class Solution {
    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (!map.containsKey(node)) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            for (UndirectedGraphNode neig : node.neighbors) {
                newNode.neighbors.add(dfs(neig, map));
            }
        }
        return map.get(node);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
}


class FirstSolution {
    private UndirectedGraphNode dfsClone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node))
            return map.get(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neig : node.neighbors)
            newNode.neighbors.add(dfsClone(neig, map));
        return newNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        dfsClone(node, map);
        return map.get(node);
    }
}



