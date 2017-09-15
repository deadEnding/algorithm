package custom.company.google.interview;

/**
 * 给一个array比如[4,2,1,3,5],根据这个array现在我们能有了一个新的array => 每个数是在原array里,
 * 在它左边的所有比它大的number的个数,就是[0,1,2,1,0]. 题目是现在给了这个[0,1,2,1,0]要求原array, 原来array的range是1~n.
 * 思路: 从后向前找 [5,4,3,2,1] 中未用到的数组第 nums[i] + 1 个数
 */
public class Reconstruct {

    public int[] reconstruct(int[] arr) {
        final int n = arr.length;
        int[] nums = new int[n];
        boolean[] used = new boolean[n];

        for (int i = n - 1; i >= 0; i--) {
            int ix = findKUnused(arr[i], used);
            nums[i] = n - ix;
            used[ix] = true;
        }

        return nums;
    }

    private int findKUnused(int k, boolean[] used) {
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && k-- == 0) {
                return i;
            }
        }
        return -1; // unreachable
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,0,4,1,3};
        int[] nums = new Reconstruct().reconstruct(arr);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
