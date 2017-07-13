package custom.company.microsoft.internship.Q201703.B;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] levelCount = new int[m];
        for (int i = 0; i < m; i++) {
            levelCount[i] = sc.nextInt();
        }

        ArrayList<Integer>[] levelNodes = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            levelNodes[i] = new ArrayList<>();
            for (int j = 0; j < levelCount[i]; j++) {
                levelNodes[i].add(sc.nextInt());
            }
        }

        ArrayList<Integer> leaf = new ArrayList<>();
        boolean[] isLeaf = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            isLeaf[sc.nextInt()] = true;
            leaf.add(i);
        }

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                dist[leaf.get(i)][leaf.get(j)] = sc.nextInt();
            }
        }

        int[] parents = new int[n + 1];
        parents[1] = 0;


    }

    private static ArrayList<Integer> resolve(int[] parent, ArrayList<Integer> up, ArrayList<Integer> down,
                                              boolean[] isLeaf) {
        ArrayList<Integer> notleaf = new ArrayList<>();
        final int n1 = up.size(), n2 = down.size();
        int ui = 0;
        parent[down.get(0)] = ui;
        if (!isLeaf[0])
            notleaf.add(down.get(0));

        for (int i = 1; i < n2; i++) {
            if (!isLeaf[i]) {
                notleaf.add(down.get(i));
            }
        }
        return null;
    }
}
