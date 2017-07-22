package leetcode.L444_SequenceReconstruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:46 PM 3/13/17
 * @version: 1.0
 * @description: https://discuss.leetcode.com/topic/73298/beat-91-concise-java-solution-and-beat-80-topological-solution-using-linkedlist
 */


public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, Integer> idx = new HashMap<>();
        HashSet<String> pairs = new HashSet<>();

        for (int i = 0; i < org.length; i++) {
            idx.put(org[i], i);
        }

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int n = seq.get(i);
                if (!idx.containsKey(n)) {
                    return false;
                }
                if (i > 0 && idx.get(seq.get(i - 1)) >= idx.get(n)) {
                    return false;
                }
                pairs.add((i == 0 ? "" : String.valueOf(seq.get(i - 1))) + ">" + n);
            }
        }

        for (int i = 0; i < org.length; i++) {
            String p = (i == 0 ? "" : String.valueOf(org[i - 1])) + ">" + org[i];
            if (!pairs.contains(p)) {
                return false;
            }
        }
        return true;
    }
}

