package custom.company.toutiao.B;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }

            set.add(x);
        }

        System.out.println(set.size());
    }
}
