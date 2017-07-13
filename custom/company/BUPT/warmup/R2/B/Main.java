package custom.company.BUPT.warmup.R2.B;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:34 PM 29/03/2017
 */


public class Main {

    static class UF {
        int[] parent;

        public UF() {
            parent = new int[256];
            for (int i = 0; i < 256; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int id) {
            while (parent[id] != id) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public boolean union(int pid, int qid) {
            int proot = findRoot(pid);
            int qroot = findRoot(qid);
            if (Character.isDigit(proot) && Character.isDigit(qroot)) {
                if (proot == qroot) {
                    return true;
                }
                return false;
            }

            if (Character.isDigit(proot)) {
                parent[qroot] = proot;
            } else {
                parent[proot] = qroot;
            }
            return true;
        }
    }

    private static long resolve(String s1, String s2) {
        final int n = s1.length();
        UF uf = new UF();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (Character.isDigit(c1) && Character.isDigit(c2) && c1 != c2) {
                return 0;
            } else {
                if (!uf.union(c1, c2)) {
                    return 0;
                }
            }
        }

        long count = 1L;
        HashSet<Integer> usedRoot = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            int root = uf.findRoot(c);
            if (!Character.isDigit(root) && !usedRoot.contains(root)) {
                usedRoot.add(root);
                count *= i == 0 ? 9 : 10;
            } else if (i == 0 && root == '0') {
                return 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 0; c < cases; c++) {
            int n = Integer.valueOf(sc.nextLine());
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(resolve(s1, s2));
        }
    }
}
