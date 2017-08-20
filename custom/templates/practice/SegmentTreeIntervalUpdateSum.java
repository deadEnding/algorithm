package custom.templates.practice;

/**
 * Created by yuhui.zzc on 13/08/2017.
 */
public class SegmentTreeIntervalUpdateSum {

    class TreeNode {
        int val;
        Integer mask;
    }

    private int n;
    private TreeNode[] tree;

    public SegmentTreeIntervalUpdateSum(int[] nums) {
        n = nums.length;
        tree = new TreeNode[4 * n];
        if (n > 0) {
            buildTree(1, nums, 0, n - 1);
        }
    }

    private void pushUp(int root) {
        tree[root].val = tree[2 * root].val + tree[2 * root + 1].val;
    }

    private void pushDown(int root, int c) {
        if (tree[root].mask != null) {
            tree[2 * root].mask = tree[2 * root + 1].mask = tree[root].mask;
            tree[2 * root].val = (c - (c >> 1)) * tree[root].mask;
            tree[2 * root + 1].val = (c >> 1) * tree[root].mask;
            tree[root].mask = null;
        }
    }

    public void buildTree(int root, int[] nums, int s, int e) {
        tree[root] = new TreeNode();
        if (s == e) {
            tree[root].val = nums[s];
        } else {
            int m = s + (e - s) / 2;
            buildTree(2 * root, nums, s, m);
            buildTree(2 * root + 1, nums, m + 1, e);
            pushUp(root);
        }
    }

    public void update(int us, int ue, int newValue) {
        update(1, 0, n - 1, us, ue, newValue);
    }

    private void update(int root, int ns, int ne, int us, int ue, int newValue) {
        if (ue < ns || ne < us) {
            return;
        }

        if (us <= ns && ne <= ue) {
            tree[root].mask = newValue;
            tree[root].val = (ne - ns + 1) * newValue;
            return;
        }


        pushDown(root, ne - ns + 1);
        int m = ns + (ne - ns) / 2;
        update(2 * root, ns, m, us, ue, newValue);
        update(2 * root + 1, m + 1, ne, us, ue, newValue);
        pushUp(root);
    }

    public int query(int qs, int qe) {
        return query(1, 0, n - 1, qs, qe);
    }

    private int query(int root, int ns, int ne, int qs, int qe) {
        if (qe < ns || ne < qs) {
            return 0;
        }

        if (qs <= ns && ne <= qe) {
            return tree[root].val;
        }

        pushDown(root, ne - ns + 1);
        int m = ns + (ne - ns) / 2;
        return query(2 * root, ns, m, qs, qe) + query(2 * root + 1, m + 1, ne, qs, qe);
    }
}
