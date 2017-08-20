package custom.company.google.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给定编号0到n-1的顶点n个，再给表示n-1边的pair对（i,j）共n-1个，i，j是顶点的编号，
 * 这些边将n个顶点连成了生成树。再给定m个需要删除的顶点序列，每删除一个顶点后，求此时
 * 的每个连通分支的顶点数的平方和，返回m个这样的平方和构成的数组，且这个数组里的元素
 * 的顺序和删除点的顺序相同。
 *
 * 离线并查集 （逆向）
 */
public class RemoveVertexFromGraph {

    class UF {
        private long sum;
        private int[] parent;
        private int[] size;

        public UF(int n, int m) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            sum = n - m;
        }

        public int find(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void addOne() {
            sum += 1;
        }

        public void union(int pid, int qid) {
            int proot = find(pid);
            int qroot = find(qid);
            System.out.println("===============================");
            System.out.println(pid + " " + proot + " " + size[proot]);
            System.out.println(qid + " " + qroot + " " + size[qroot]);
            if (proot != qroot) {
                parent[qroot] = proot;
                sum += 2 * size[proot] * size[qroot];
                size[proot] += size[qroot];
            }
            System.out.println(sum);
        }

        public long getSum() {
            return sum;
        }
    }

    public long[] remove(int n, int[][] edges, int[] removed) {
        final int m = removed.length;
        HashSet<Integer> rm = new HashSet<>();
        for (int r : removed) {
            rm.add(r);
        }

        UF uf = new UF(n, m);
        HashMap<Integer, List<Integer>> rmEdges = new HashMap<>();
        for (int[] edge : edges) {
            if (rm.contains(edge[0])) {
                if (!rmEdges.containsKey(edge[0])) {
                    rmEdges.put(edge[0], new ArrayList<>());
                }
                rmEdges.get(edge[0]).add(edge[1]);
            } else if (rm.contains(edge[1])) {
                if (!rmEdges.containsKey(edge[1])) {
                    rmEdges.put(edge[1], new ArrayList<>());
                }
                rmEdges.get(edge[1]).add(edge[0]);
            } else {
                uf.union(edge[0], edge[1]);
            }
        }

        long[] result = new long[m];
        for (int i = m - 1; i >= 0; i--) {
            result[i] = uf.getSum();
            uf.addOne();
            if (rmEdges.containsKey(removed[i])) {
                for (int adj : rmEdges.get(removed[i])) {
                    uf.union(removed[i], adj);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1}, {1,2}, {0,2}, {2,3}};
        int[] removed = {1,2};
        long[] sums = new RemoveVertexFromGraph().remove(n, edges, removed);
        for (long sum : sums) {
            System.out.println(sum);
        }
    }

}
