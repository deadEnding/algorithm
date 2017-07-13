package leetcode.again.L406_QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:46 AM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> (p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]));
        List<int[]> np = new LinkedList<>();
        for (int[] p : people) {
            np.add(p[1], p);
        }
        return np.toArray(new int[people.length][2]);
    }
}


class BasicSolution {
    private void insert(ArrayList<int[]> np, int[] p) {
        int ix = 0, count = 0;
        while (ix < np.size() && count <= p[1]) {
            if (np.get(ix)[0] >= p[0]) {
                if (count == p[1]) {
                    break;
                }
                count++;
            }
            ix++;
        }
        np.add(ix, p);
    }

    public int[][] reconstructQueue(int[][] people) {
        final int n = people.length;
        Arrays.sort(people, (p1, p2) -> (p1[1] != p2[1] ? p1[1] - p2[1] : p1[0] - p2[0]));

        ArrayList<int[]> np = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            insert(np, people[i]);
        }

        int[][] newPeople = new int[n][2];
        for (int i = 0; i < n; i++) {
            newPeople[i] = np.get(i);
        }
        return newPeople;
    }
}
