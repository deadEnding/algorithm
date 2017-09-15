package custom.templates.practice;

public class SegTreePoint {

    private int n;
    private int[] tree;

    public SegTreePoint(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(1, 0, n - 1, nums);
    }

    public void build(int root, int ns, int ne, int[] nums) {
        if (ns == ne) {
            tree[ns] = nums[ns];
        } else {
            int nm = ns + (ne - ns) / 2;
            build(2 * root, ns, nm, nums);
            build(2 * root + 1, nm + 1, ne, nums);
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    public void update(int root, int ns, int ne, int ix, int newVal) {
        if (ns == ix && ix == ne) {
            tree[root] = newVal;
        } else {
            int nm = ns + (ne - ns) / 2;
            if (ix <= nm) {
                update(2 * root, ns, nm, ix, newVal);
            } else {
                update(2 * root + 1, nm + 1, ne, ix, newVal);
            }
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    public int query(int root, int ns, int ne, int qs, int qe) {
        if (qe < ns || ne < qs) {
            return 0;
        }

        if (qs <= ns && ne <= qe) {
            return tree[root];
        }

        int nm = ns + (ne - ns) / 2;
        return query(2 * root, ns, nm, qs, qe) + query(2 * root + 1, nm + 1, ne, qs, qe);
    }
}
