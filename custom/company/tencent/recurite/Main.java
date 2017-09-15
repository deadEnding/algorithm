package custom.company.tencent.recurite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static int[] x = new int[4];
    public static int[] y = new int[4];

    public static int dist(int i, int j) {
        int dx = x[i] - x[j];
        int dy = y[i] - y[j];
        return dx * dx + dy * dy;
    }

    public static boolean solve() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int d = dist(i, j);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
        }

        if (map.size() != 2) {
            return false;
        }

        ArrayList<Integer> two = new ArrayList<>();
        two.addAll(map.keySet());
        int d1 = two.get(0);
        int d2 = two.get(1);
        if (map.get(d1) == 2 && map.get(d2) == 4) {
            return d1 == 2 * d2;
        } else if (map.get(d1) == 4 && map.get(d2) == 2) {
            return d2 == 2 * d1;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int _c = 0; _c < cases; _c++) {
            for (int i = 0; i < 4; i++) {
                x[i] = sc.nextInt();
            }

            for (int i = 0; i < 4; i++) {
                y[i] = sc.nextInt();
            }

            System.out.println(solve() ? "Yes" : "No");
        }
    }
}
