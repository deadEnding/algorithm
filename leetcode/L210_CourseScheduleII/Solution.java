package leetcode.L210_CourseScheduleII;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 9:15 AM 12/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];
        for (int[] pair: prerequisites) {
            adjacency[pair[1]].add(pair[0]);
            indegree[pair[0]]++;
        }

        int[] courses = new int[numCourses];
        for (int i = 0, j; i < numCourses; i++) {
            for (j = 0; j < numCourses && indegree[j] != 0; j++) {}

            if (j == numCourses) {
                return new int[0];
            }

            indegree[j] = -1;
            courses[i] = j;
            for (int next : adjacency[j]) {
                indegree[next]--;
            }
        }
        return courses;
    }
}
