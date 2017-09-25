package custom.company.airbnb.codetest.B;

import java.util.LinkedList;

public class Main {

    static int min = Integer.MAX_VALUE;
    static LinkedList<Integer> minPath = new LinkedList<Integer>() {{ add(0); }};

    static void dfs(int ix, LinkedList<Integer>[] nexts, LinkedList<Integer> path, int cost, boolean[] visited) {
        if (visited[ix]) {
            return;
        }

        if (ix == 9) {
            if (cost < min) {
                min = cost;
                minPath = new LinkedList<>(path);
            }
            return;
        }

        visited[ix] = true;
        for (int next : nexts[ix]) {
            path.addLast(next);
            dfs(next, nexts, path, cost + (ix - next) * (ix - next), visited);
            path.removeLast();
        }

        visited[ix] = false;
    }

    static int[] meet(String[] wizards) {
        LinkedList<Integer>[] nexts = new LinkedList[wizards.length];
        for (int i = 0; i < wizards.length; i++) {
            nexts[i] = new LinkedList<>();
            if (!wizards[i].equals("")) {
                for (String t : wizards[i].split(" ")) {
                    nexts[i].add(Integer.valueOf(t));
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(0, nexts, path, 0, new boolean[10]);
        int[] p = new int[minPath.size()];
        int ix = 0;
        for (int q : minPath) {
            p[ix++] = q;
        }
        return p;
    }

    public static void main(String[] args) {
        String[] w = {
                "1 2 3",
                "8 6 4",
                "7 8 3",
                "8 1",
                "",
                "8 7",
                "4",
                "4 6",
                "1",
                "1 4"};
        int[] p = meet(w);
        for (int x :p) {
            System.out.println(x);
        }
    }
}
