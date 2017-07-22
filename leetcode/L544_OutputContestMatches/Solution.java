package leetcode.again.L544_OutputContestMatches;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 11:47 PM 02/04/2017
 */


public class Solution {
    private ArrayList<String> helper(ArrayList<String> rank) {
        if (rank.size() == 1) {
            return rank;
        }

        final int n = rank.size();
        ArrayList<String> nextRank = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            nextRank.add(String.format("(%s,%s)", rank.get(i), rank.get(n - 1 - i)));
        }
        return helper(nextRank);
    }

    public String findContestMatch(int n) {
        ArrayList<String> rank = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            rank.add(String.valueOf(i));
        }
        return helper(rank).get(0);
    }
}
