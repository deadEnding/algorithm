package custom.codinginterviews.CH4;

/**
 * @author: deadend
 * @date: 2:07 PM 2/6/17
 * @version: 1.0
 * @description:
 * http://stackoverflow.com/questions/25355191/is-there-a-linear-solution-to-determining-whether-a-postorder-sequence-is-a-vali
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 */


public class PostOrderOfBST {

    private boolean isPostOrder(int[] nums, int s, int e) {
        if (s >= e) {
            return true;
        }

        int smaller = e - 1;
        while (smaller >= s && nums[smaller] > nums[e]) {
            smaller--;
        }

        for (int i = smaller; i >= s; i--) {
            if (nums[i] > nums[e]) {
                return false;
            }
        }

        return isPostOrder(nums, s, smaller) && isPostOrder(nums, smaller + 1, e - 1);
    }

    public boolean isPostOrder(int[] nums) {
        return isPostOrder(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(new PostOrderOfBST().isPostOrder(nums));
    }
}
