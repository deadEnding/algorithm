package custom.templates;


public class SegmentTreePointUpdate {

    int n;
    int[] tree;

    public SegmentTreePointUpdate(int[] nums) {
        n = nums.length;
        if (n > 0) {
            tree = new int[4 * n];
            build(1, 0, n - 1, nums);
        }
    }

    public void build(int root, int ns, int ne, int[] nums) {
        if (ns == ne) {
            tree[root] = nums[ns];
        } else {
            int m = ns + (ne - ns) / 2;
            build(2 * root, ns, m, nums);
            build(2 * root + 1, m + 1, ne, nums);
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
