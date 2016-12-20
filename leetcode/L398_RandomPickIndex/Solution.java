package leetcode.L398_RandomPickIndex;

import java.util.*;

/**
 * @author: deadend
 * @date: 12:46 PM 12/20/16
 * @version: 1.0
 * @description:
 */

public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int index = -1;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (random.nextInt(++count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}


class BasicSolution {

    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private Random random = new Random();

    public BasicSolution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> index = map.get(target);
        return index.get(random.nextInt(index.size()));
    }
}
