package leetcode.L307_RangeSumQueryMutable;


public class NumArray {

    int n;
    int[] tree;

    public NumArray(int[] nums) {
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
