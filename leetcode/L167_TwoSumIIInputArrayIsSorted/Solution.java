package leetcode.L167_TwoSumIIInputArrayIsSorted;

/**
 * @author: deadend
 * @date: 4:55 PM 11/22/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,4,9,56,90};
        for (int ix : new Solution().twoSum(numbers, 8)) {
            System.out.println(ix);
        }
    }
}

class Solution1 {
    private int search(int[] numbers, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int ix = search(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (ix > 0) {
                return new int[]{i + 1, ix + 1};
            }
        }
        return null;
    }
}
