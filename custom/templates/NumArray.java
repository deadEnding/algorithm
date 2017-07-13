package custom.templates;

/**
 * @author: deadend
 * @date: 12:31 PM 12/13/16
 * @version: 1.0
 * @description:
 */

public class NumArray {

    private int[] tree;
    private int n;

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < tree.length; i++) {
            tree[i] = nums[j++];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public NumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            tree = new int[2 * n];
            buildTree(nums);
        }
    }

    void update(int i, int val) {
        tree[i + n] = val;
        for (int k = (i + n) / 2; k > 0; k /= 2) {
            tree[k] = tree[2 * k] + tree[2 * k + 1];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (i += n, j += n; i <= j; i /= 2, j /= 2) {
            sum += i % 2 == 1 ? tree[i++] : 0;
            sum += j % 2 == 0 ? tree[j--] : 0;
        }
        return sum;
    }
}

class TreeNumArray {

    // 叶子节点sum为元素值
    class SegmentTreeNode {
        int start, end;
        int sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int s, int e) {
            start = s;
            end = e;
        }
    }

    private SegmentTreeNode root;

    private SegmentTreeNode buildTree(int[] nums, int left, int right) {
        SegmentTreeNode root = new SegmentTreeNode(left, right);
        if (left == right) {
            root.sum = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            root.left = buildTree(nums, left, mid);
            root.right = buildTree(nums, mid + 1, right);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    private void updateTree(SegmentTreeNode root, int i, int val) {
        if (root.start == i && root.end == i) {
            root.sum = val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (i <= mid) {
            updateTree(root.left, i, val);
        } else {
            updateTree(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    private int sumRangeTree(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return sumRangeTree(root.left, i, j);
        } else if (i > mid) {
            return sumRangeTree(root.right, i, j);
        } else {
            return sumRangeTree(root.left, i, mid) + sumRangeTree(root.right, mid + 1, j);
        }
    }

    public TreeNumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        root = buildTree(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        updateTree(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeTree(root, i, j);
    }
}


class OtherNumArray {

    private int len;     // 每段的长度，段的个数
    private int[] b;     // 各段的和
    private int[] nums;

    public OtherNumArray(int[] nums) {
        this.nums = nums;
        len = (int) Math.ceil(Math.sqrt(nums.length));
        b = new int[len];
        for (int i = 0; i < nums.length; i++) {
            b[i / len] += nums[i];
        }
    }

    void update(int i, int val) {
        b[i / len] += val - nums[i];
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int x = i / len;
        int y = j / len;
        int sum = 0;
        if (y - x <= 1) {
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
        } else {
            for (int k = i; k < (x + 1) * len; k++) {
                sum += nums[k];
            }

            for (int k = x + 1; k < y; k++) {
                sum += b[k];
            }

            for (int k = y * len; k <= j; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }
}

