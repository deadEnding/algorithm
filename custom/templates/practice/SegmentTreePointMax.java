package custom.templates.practice;

public class SegmentTreePointMax {

    class TreeNode {
        int val;
    }

    class SegmentTree {

        private int n;
        private TreeNode[] tree;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new TreeNode[4 * n];
            build(1, nums, 0, n - 1);
        }

        public void pushUp(int root) {
            tree[root].val = Math.max(tree[2 * root].val, tree[2 * root + 1].val);
        }

        public void build(int root, int[] nums, int s, int e) {
            tree[root] = new TreeNode();
            if (s == e) {
                tree[root].val = nums[s];
            } else {
                int m = s + (e - s) / 2;
                build(2 * root, nums, s, m);
                build(2 * root + 1, nums, m + 1, e);
                pushUp(root);
            }
        }

        public void update(int root, int ns, int ne, int ix, int val) {
            if (ix < ns || ix > ne) {
                return;
            }

            if (ns == ix && ix == ne) {
                tree[root].val = val;
                return;
            }

            int m = ns + (ne - ns) / 2;
            update(2 * root, ns, m, ix, val);
            update(2 * root + 1, m + 1, ne, ix, val);
            pushUp(root);
        }

        public int query(int root, int ns, int ne, int qs, int qe) {
            if (qe < ns || ne < qs) {
                return Integer.MIN_VALUE;
            }

            if (qs <= ns && ne <= qe) {
                return tree[root].val;
            }

            int m = ns + (ne - ns) / 2;
            return Math.max(query(2 * root, ns, m, qs, qe), query(2 * root + 1, m + 1, ne, qs, qe));
        }


    }

    private int n;
    private SegmentTree segmentTree;

    public SegmentTreePointMax(int[] nums) {
        n = nums.length;
        segmentTree = new SegmentTree(nums);
    }

    public void update(int ix, int val) {
        segmentTree.update(1, 0, n - 1, ix, val);
    }

    public int query(int qs, int qe) {
        return segmentTree.query(1, 0, n - 1, qs, qe);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        SegmentTreePointMax m = new SegmentTreePointMax(nums);
        m.update(0, 6);
        System.out.println(m.query(1, 1));
    }
}
