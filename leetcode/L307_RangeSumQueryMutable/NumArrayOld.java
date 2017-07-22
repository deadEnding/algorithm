package leetcode.again.L307_RangeSumQueryMutable;

/**
 * @author: deadend
 * @date: 9:28 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class NumArrayOld {
    class BIT {
        private int[] sums;

        public BIT(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        private int lowBit(int x) {
            return x & -x;
        }

        public void add(int i, int diff) {
            while (i < sums.length) {
                sums[i] += diff;
                i += lowBit(i);
            }
        }

        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += sums[i];
                i -= lowBit(i);
            }
            return s;
        }
    }

    private BIT bit;
    private int[] nums;

    public NumArrayOld(int[] nums) {
        bit = new BIT(nums);
        this.nums = nums;
    }

    public void update(int i, int val) {
        bit.add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return bit.sum(j + 1) - bit.sum(i);
    }
}


// 线段树数组实现
class TreeArrayNumArray {

    int n;
    int[] tree;

    public TreeArrayNumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            tree = new int[2 * n];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        tree[n + i] = val;
        for (int k = (n + i) / 2; k > 0; k /= 2) {
            tree[k] = tree[2 * k] + tree[2 * k + 1];
        }
    }


    private int sumRange0(int i, int j) {
        int sum = 0;
        if (i <= j) {
            sum += i % 2 == 1 ? tree[i++] : 0;
            sum += j % 2 == 0 ? tree[j--] : 0;
            sum += sumRange0(i / 2, j / 2);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return sumRange0(n + i, n + j);
    }
}


// 线段树二叉树实现
class SegmentTreeNumArray {

    class Node {
        int start, end;
        int sum;
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
        }
    }

    private Node root;

    public SegmentTreeNumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        root = build(nums, 0, nums.length - 1);
    }

    private Node build(int[] nums, int s, int e) {
        Node root = new Node(s, e);
        if (s == e) {
            root.sum = nums[s];
        } else {
            int m = s + (e - s) / 2;
            root.left = build(nums, s, m);
            root.right = build(nums, m + 1, e);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    private void update(Node root, int i, int val) {
        if (root.start == i && i == root.end) {
            root.sum = val;
        } else {
            int m = root.start + (root.end - root.start) / 2;
            if (i <= m) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private int sumRange(Node root, int i, int j) {
        if (i == root.start && j == root.end) {
            return root.sum;
        }

        int m = root.start + (root.end - root.start) / 2;
        if (j <= m) {
            return sumRange(root.left, i, j);
        } else if (i > m) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, m) + sumRange(root.right, m + 1, j);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArrayOld numArray = new NumArrayOld(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
