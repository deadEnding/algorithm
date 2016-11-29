package leetcode.L406_QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: deadend
 * @date: 9:12 AM 11/28/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        final int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[][] result = new int[n][2];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int j = -1;
            int count = 0;
            while (count <= people[i][1]) {
                j++;
                if (!used[j] || result[j][0] >= people[i][0]) {
                    count++;
                }
            }
            result[j] = people[i];
            used[j] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = new Solution().reconstructQueue(people);
        for (int[] p : result) {
            for (int x : p) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class TimeOutSolution {

    private boolean dfs(int ix, boolean[] used, int[][] people, int[][] result) {
        if (ix >= result.length) {
            return true;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                int count = 0;
                for (int j = 0; j < ix; j++) {
                    count += result[j][0] >= people[i][0] ? 1 : 0;
                }
                if (count != people[i][1]) {
                    continue;
                }
                used[i] = true;
                result[ix] = people[i];
                if (dfs(ix + 1, used, people, result)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public int[][] reconstructQueue(int[][] people) {
        final int n = people.length;
        int[][] result = new int[n][2];
        dfs(0, new boolean[n], people, result);
        return result;
    }
}
