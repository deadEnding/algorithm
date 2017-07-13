package custom.company.toutiao.A;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (set.contains(x)) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(x);
            }
        }
    }
}
