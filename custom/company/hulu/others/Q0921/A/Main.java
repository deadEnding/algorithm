package custom.company.hulu.others.Q0921.A;

import java.util.*;

public class Main {

    private static int n, k;
    private static LinkedList<Integer> stack;
    private static ArrayList<Integer>[] methods;

    public static int dfs(int ix, LinkedList<Integer> path, boolean[] visited, HashSet<Integer> cache) {
        if (ix == -1) {
            stack = new LinkedList<>(path);
            stack.pop();
            return -1;
        }

        if (ix == 0) {
            return 0;
        }

        if (visited[ix]) {
            return -2;
        }

        if (cache.contains(ix)) {
            return 0;
        }

        visited[ix] = true;
        for (int next : methods[ix]) {
            path.push(next);
            int r = dfs(next, path, visited, cache);
            if (r <= 0) {
                path.pop();
                return r;
            }
            path.pop();
        }

        visited[ix] = false;
        cache.add(ix);
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nk = sc.nextLine().split(" ");
        n = Integer.valueOf(nk[0]);
        k = Integer.valueOf(nk[1]);

        methods = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            methods[i] = new ArrayList<>();
            String[] ms = sc.nextLine().split(" ");
            for (String mid : ms) {
                methods[i].add(Integer.valueOf(mid));
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.push(k);
        int ret = dfs(k, path, new boolean[n + 1], new HashSet<Integer>());
        if (ret == -2) {
            System.out.println("E");
        } else if (ret == -1) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
                if (!stack.isEmpty()) {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println("R");
        }
    }
}
