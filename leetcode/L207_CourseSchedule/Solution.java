package leetcode.L207_CourseSchedule;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 7:57 PM 12/8/16
 * @version: 1.0
 * @description:
 */


// 拓扑排序: 每次删除入度为0的节点
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] adjacency = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new HashSet<>();
        }

        for (int[] pair : prerequisites) {
            adjacency[pair[1]].add(pair[0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int next : adjacency[i]) {
                indegree[next]++;
            }
        }

        for (int i = 0, j; i < numCourses; i++) {
            for (j = 0; j < numCourses && indegree[j] != 0; j++) {}

            if (j == numCourses) {
                return false;
            }

            indegree[j] = -1;
            for (int next : adjacency[j]) {
                indegree[next]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] pre = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        int n = 10;
        System.out.println(new Solution().canFinish(n, pre));
    }
}

class DFSSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] pair : prerequisites) {
            adjacency[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adjacency, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int ix, ArrayList<Integer>[] adjacency, boolean[] visited) {
        if (visited[ix]) {
            return true;
        }

        visited[ix] = true;
        for (int i = 0; i < adjacency[ix].size(); i++) {    // 使用for-each会超时
            if (hasCycle(adjacency[ix].get(i), adjacency, visited)) {
                return true;
            }
        }
        visited[ix] = false;
        return false;
    }
}