package custom.company.netease.intern.Q0326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class RememberWords {

    private static int resolve(HashSet<String> remember, HashSet<String> dict) {
        int sum = 0;
        for (String r : remember) {
            if (dict.contains(r)) {
                sum += r.length() * r.length();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<String> reme = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            list.add(s);
            reme.add(s);
        }

        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            list.add(s);
            dict.add(s);
        }
        for (String s: list) {
            System.out.println(s);
        }

        System.out.println(resolve(reme, dict));
    }
}
