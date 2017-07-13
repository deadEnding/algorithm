package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 4:42 PM 12/27/16
 * @version: 1.0
 * @description: 给定升序数组，创建高度最小的二叉搜索树
 */


public class CreateBST {

    public TreeNode create(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid - 1);
        root.right = create(nums, mid + 1, end);
        return root;
    }

    public TreeNode create(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }
}
