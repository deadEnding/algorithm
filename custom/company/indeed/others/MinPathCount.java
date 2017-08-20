package custom.company.indeed.others;

import java.util.HashMap;
import java.util.List;

public class MinPathCount {

    class Node {
        List<Edge> edges;
    }

    class Edge {
        Node node;
        int cost;
    }

    public int getMinPathCount(Node root, HashMap<Node, Integer> cache) {
        if (root.edges.isEmpty()) {
            return 0;
        }

        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        int min = Integer.MAX_VALUE;
        for (Edge edge : root.edges) {
            min = Math.min(min, edge.cost + getMinPathCount(edge.node, cache));
        }

        cache.put(root, min);
        return min;
    }
}
