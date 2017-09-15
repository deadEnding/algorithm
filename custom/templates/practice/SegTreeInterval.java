package custom.templates.practice;

public class SegTreeInterval {

    class Node {
        int val;
        int mask;
    }

    private int n;
    private Node[] tree;

    public SegTreeInterval(int[] nums) {
        n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1, nums);
    }

    public void pushUp(int root) {
        tree[root].val = tree[2 * root].val + tree[2 * root + 1].val;
    }

    public void pushDown(int root, int ns, int ne) {
        int nm = ns + (ne - ns) / 2;
        int delta = tree[root].mask;
        tree[2 * root].mask = tree[2 * root + 1].mask = delta;
        tree[2 * root].val += delta * (nm - ns + 1);
        tree[2 * root + 1].val += delta * (ne - nm);
    }

    public void build(int root, int ns, int ne, int[] nums) {
        tree[root] = new Node();
        if (ns == ne) {
            tree[root].val = nums[ns];
        } else {
            int nm = ns + (ne - ns) / 2;
            build(2 * root, ns, nm, nums);
            build(2 * root + 1, nm + 1, ne, nums);
            pushUp(root);
        }
    }

    public void update(int root, int ns, int ne, int us, int ue, int detal) {
        if (ne < us || ue < ns) {
            return;
        }

        if (us <= ns && ne <= ue) {
            tree[root].val += detal * (ne - ns + 1);
            tree[root].mask = detal;
            return;
        }

        pushDown(root, ns, ne);
        int nm = ns + (ne - ns) / 2;
        update(2 * root, ns, nm, us, ue, detal);
        update(2 * root + 1, nm + 1, ne, us, ue, detal);
        pushUp(root);
    }

    public int query(int root, int ns, int ne, int qs, int qe) {
        if (ne < qs || qe < ns) {
            return 0;
        }

        if (qs <= ns && ne <= qe) {
            return tree[root].val;
        }

        pushDown(root, ns, ne);
        int nm = ns + (ne - ns) / 2;
        return query(2 * root, ns, nm, qs, qe) + query(2 * root + 1, nm + 1, ne, qs, qe);
    }

}
