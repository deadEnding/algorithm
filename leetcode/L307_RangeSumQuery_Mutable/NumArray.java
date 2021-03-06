package leetcode.L307_RangeSumQuery_Mutable;

/**
 * @author: deadend
 * @date: 12:31 PM 12/13/16
 * @version: 1.0
 * @description:
 */

class NumArray {

    class BIT {
        int[] sums;
        public BIT(int[] nums) {
            final int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i, nums[i]);
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void add(int ix, int delta) {
            ix++;
            while (ix < sums.length) {
                sums[ix] += delta;
                ix += lowbit(ix);
            }
        }

        public int sum(int ix) {
            ix++;
            int sum = 0;
            while (ix > 0) {
                sum += sums[ix];
                ix -= lowbit(ix);
            }
            return sum;
        }
    }

    private BIT bit;
    private int[] nums;

    public NumArray(int[] nums) {
        bit = new BIT(nums);
        this.nums = nums;
    }

    public void update(int i, int val) {
        bit.add(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return bit.sum(j) - bit.sum(i - 1);
    }
}


class BITNumArray {

    class BIT {
        int[] sums;

        public BIT(int[] nums) {
            final int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i, nums[i]);
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void add(int ix, int delta) {
            ix++;
            while (ix < sums.length) {
                System.out.println(ix + " " + lowbit(ix));
                sums[ix] += delta;
                ix += lowbit(ix);
            }
        }

        public int sum(int ix) {
            ix++;
            int sum = 0;
            while (ix > 0) {
                sum += sums[ix];
                ix -= lowbit(ix);
            }
            return sum;
        }
    }

    private int[] nums;
    private BIT bit;

    public BITNumArray(int[] nums) {
        this.nums = nums;
        this.bit = new BIT(nums);
    }

    public void update(int i, int val) {
        bit.add(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return bit.sum(j) - bit.sum(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class SegmentTreeNumArray {

    int n;
    int[] tree;

    public SegmentTreeNumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            tree = new int[4 * n];
            build(1, nums, 0, n - 1);
        }
    }

    public void build(int root, int[] nums, int s, int e) {
        if (s == e) {
            tree[root] = nums[s];
        } else {
            int m = s + (e - s) / 2;
            build(2 * root, nums, s, m);
            build(2 * root + 1, nums, m + 1, e);
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    public void update(int root, int ns, int ne, int ix, int val) {
        if (ns == ix && ix == ne) {
            tree[root] = val;
        } else {
            int m = ns + (ne - ns) / 2;
            if (ix <= m) {
                update(2 * root, ns, m, ix, val);
            } else {
                update(2 * root + 1, m + 1, ne, ix , val);
            }
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    public int query(int root, int ns, int ne, int qs, int qe) {
        if (ns > qe || qs > ne) {
            return 0;
        }

        if (qs <= ns && ne <= qe) {
            return tree[root];
        }

        int m = ns + (ne - ns) / 2;
        return query(2 * root, ns, m, qs, qe) + query(2 * root + 1, m + 1, ne, qs, qe);
    }

    public void update(int i, int val) {
        update(1, 0, n - 1, i, val);
    }

    public int sumRange(int i, int j) {
        return query(1, 0, n - 1, i, j);
    }
}

class OldNumArray {

    class BIT {
        private int[] sums;

        public BIT(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void add(int ix, int diff) {
            while (ix < sums.length) {
                sums[ix] += diff;
                ix += lowbit(ix);
            }
        }

        public int sum(int ix) {
            int s = 0;
            while (ix > 0) {
                s += sums[ix];
                ix -= lowbit(ix);
            }
            return s;
        }
    }

    private int[] nums;
    private BIT bit;

    public OldNumArray(int[] nums) {
        this.nums = nums;
        this.bit = new BIT(nums);
    }

    public void update(int i, int val) {
        bit.add(i + 1, val - nums[i]);
        nums[i] = val;   // 保存下更新值
    }

    public int sumRange(int i, int j) {
        return bit.sum(j + 1) - bit.sum(i);
    }
}


class ArrayNumArray {

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

    public ArrayNumArray(int[] nums) {
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

