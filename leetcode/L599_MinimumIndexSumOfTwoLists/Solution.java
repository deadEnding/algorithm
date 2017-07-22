package leetcode.again.L599_MinimumIndexSumOfTwoLists;


import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        ArrayList<String> result = null;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum == minIndex) {
                    result.add(list2[i]);
                } else if (sum < minIndex) {
                    minIndex = sum;
                    result = new ArrayList<>();
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[] {});
    }
}
