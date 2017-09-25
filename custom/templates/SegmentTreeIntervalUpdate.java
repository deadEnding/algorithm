package custom.templates;

import java.util.Scanner;

public class SegmentTreeIntervalUpdate {

    static class TreeNode {
        int val;
        int mask;
    }

    static class SegmentTree {

        int n;
        TreeNode[] tree;

        public SegmentTree(int[] p) {
            n = p.length;
            tree = new TreeNode[4 * n];
            build(1, 0, n - 1, p);
        }

        public void pushUp(int root) {
            tree[root].val = tree[2 * root].val + tree[2 * root + 1].val;
        }

        public void pushDown(int root, int c) {
            if (tree[root].mask != 0) {
                tree[2 * root].mask = tree[2 * root + 1].mask = tree[root].mask;
                tree[2 * root].val = (c - (c >> 1)) * tree[root].mask;
                tree[2 * root + 1].val = (c >> 1) * tree[root].mask;
                tree[root].mask = 0;
            }
        }

        public void build(int root, int s, int e, int[] p) {
            tree[root] = new TreeNode();
            if (s == e) {
                tree[root].val = p[s];
            } else {
                int m = s + (e - s) / 2;
                build(2 * root, s, m, p);
                build(2 * root + 1, m + 1, e, p);
                pushUp(root);
            }
        }


        public void update(int root, int ns, int ne, int us, int ue, int newVal) {
            if (ne < us || ue < ns) {
                return;
            }

            if (us <= ns && ne <= ue) {
                tree[root].mask = newVal;
                tree[root].val = (ne - ns + 1) * newVal;
                return;
            }

            pushDown(root, ne - ns + 1);
            int m = ns + (ne - ns) / 2;
            update(2 * root, ns, m, us, ue, newVal);
            update(2 * root + 1, m + 1, ne, us, ue, newVal);
            pushUp(root);
        }

        public int query(int root, int ns, int ne, int qs, int qe) {
            if (ne < qs || qe < ns) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        SegmentTree tree = new SegmentTree(p);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            if (type == 0) {
                System.out.println(tree.query(1, 0, n - 1, l, r));
            } else {
                int np = sc.nextInt();
                tree.update(1, 0, n - 1, l, r, np);
            }
        }
    }
}
