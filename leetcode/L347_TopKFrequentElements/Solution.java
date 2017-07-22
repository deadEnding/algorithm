package leetcode.again.L347_TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 12:32 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : counter.keySet()) {
            int count = counter.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }

        LinkedList<Integer> topK = new LinkedList<>();
        for (int i = nums.length; i > 0 && k > 0; i--) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
                k -= buckets[i].size();
            }
        }
        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().topKFrequent(nums, 1));
    }
}
