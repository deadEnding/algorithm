package custom.templates.practice;

/**
 * Created by yuhui.zzc on 13/08/2017.
 */
public class SegmentTreePointUpdateSum {

    private int n;
    private int[] tree;

    public SegmentTreePointUpdateSum(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        if (n > 0) {
            buildTree(1, nums, 0, n - 1);
        }
    }

    private void buildTree(int root, int[] nums, int s, int e) {
        if (s == e) {
            tree[root] = nums[s];
        } else {
            int m = s + (e - s) / 2;
            buildTree(2 * root, nums, s, m);
            buildTree(2 * root + 1, nums, m + 1, e);
            tree[root] = tree[2 * root] + tree[2 * root + 1];
        }
    }

    public void update(int root, int ns, int ne, int ix, int newVal) {
        if (ns == ix && ix == ne) {
            tree[root] = newVal;
        } else {
            int m = ns + (ne - ns) / 2;
            if (ix <= m) {
                update(2 * root, ns, m, ix, newVal);
            } else {
                update(2 * root + 1, m + 1, ne, ix, newVal);
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

        int m = ns + (ne - ns) / 2;
        return query(2 * root, ns, m, qs, qe) + query(2 * root + 1, m + 1, ne, qs, qe);
    }
}
