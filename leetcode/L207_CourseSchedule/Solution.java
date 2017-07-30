package leetcode.L207_CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 12:45 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] children = new HashSet[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            children[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            children[p[1]].add(p[0]);
        }

        int count = numCourses;
        while (count > 0) {
            HashSet<Integer> removed = new HashSet<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    removed.add(i);
                }
            }

            if (removed.isEmpty()) {
                return false;
            }

            for (int rm : removed) {
                indegree[rm] = -1;
                for (int child : children[rm]) {
                    indegree[child]--;
                }
            }

            count -= removed.size();
        }

        return true;
    }
}


class OldSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] adj = new HashSet[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        int count = numCourses;
        while (count > 0) {
            HashSet<Integer> removed = new HashSet<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    removed.add(i);
                }
            }

            if (removed.isEmpty()) {
                return false;
            }

            for (int rm : removed) {
                indegree[rm] = -1;
                for (int neig : adj[rm]) {
                    indegree[neig]--;
                }
            }
            count -= removed.size();
        }
        return true;
    }
}

class DFSSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int ix, ArrayList<Integer>[] adj, boolean[] visited) {
        if (visited[ix]) {
            return true;
        }

        visited[ix] = true;
        for (int i = 0; i < adj[ix].size(); i++) {
            if (hasCycle(adj[ix].get(i), adj, visited)) {
                return true;
            }
        }
        visited[ix] = false;
        return false;
    }
}