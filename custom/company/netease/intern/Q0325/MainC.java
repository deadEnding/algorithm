package custom.company.netease.intern.Q0325;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class MainC {

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
        String nm = sc.nextLine();
        HashSet<String> remember = new HashSet<>();

        String[] ns = sc.nextLine().trim().split(" ");
        for (String s: ns) {
            remember.add(s);
        }

        HashSet<String> dict = new HashSet<>();
        String[] ms = sc.nextLine().trim().split(" ");
        for (String s : ms) {
            dict.add(s);
        }

        System.out.println(resolve(remember, dict));
    }
}
