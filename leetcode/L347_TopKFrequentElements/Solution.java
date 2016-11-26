package leetcode.L347_TopKFrequentElements;

import java.util.*;

/**
 * @author: deadend
 * @date: 2:45 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.containsKey(n) ? counter.get(n) + 1 : 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            counter.size(),
            new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            }
        );

        heap.addAll(counter.entrySet());
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(heap.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> result = new BucketSolution().topKFrequent(nums, 2);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class BucketSolution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.containsKey(n) ? counter.get(n) + 1 : 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : counter.keySet()) {
            int count = counter.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }

        List<Integer> topK = new LinkedList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }

            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
                k -= buckets[i].size();
            }
        }
        return topK;
    }
}
