package custom.CC150.CH4;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:55 PM 12/27/16
 * @version: 1.0
 * @description:
 */


public class IsPathExist {

    private boolean existUsingDFS(GraphNode start, GraphNode end, HashSet<GraphNode> visited) {
        if (start == end) {
            return true;
        }

        visited.add(start);
        for (GraphNode adj : start.adjacent) {
            if (!visited.contains(adj) && existUsingDFS(adj, end, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean existUsingBFS(GraphNode start, GraphNode end, HashSet<GraphNode> visited) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            GraphNode p = queue.poll();
            if (p == end) {
                return true;
            }
            visited.add(p);
            for (GraphNode adj : p.adjacent) {
                queue.offer(adj);
            }
        }
        return false;
    }

    public boolean exist(GraphNode start, GraphNode end) {
        return existUsingDFS(start, end, new HashSet<GraphNode>());
    }
}
