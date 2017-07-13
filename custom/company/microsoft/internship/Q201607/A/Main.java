package custom.company.microsoft.internship.Q201607.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 10:09 AM 31/03/2017
 */


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        ArrayList<String[]> lts = new ArrayList<>();
        ArrayList<String[]> les = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    set.add(c);
                }
            }
            String[] vars = line.split("(<=)|(<)", -1);
            String[] ops = line.split("([A-Z])|(\\d+)", -1);
            for (int j = 1; j < vars.length; j++) {
                if (ops[j].equals("<")) {
                    lts.add(new String[] {vars[j - 1], vars[j]});
                } else {
                    les.add(new String[] {vars[j - 1], vars[j]});
                }
            }
        }

        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 0; c < cases; c++) {
            HashMap<String, Integer> vmap = new HashMap<>();
            for (int i = 0; i < set.size(); i++) {
                String[] pairs = sc.nextLine().split(" ");
                vmap.put(pairs[0], Integer.valueOf(pairs[1]));
            }

            boolean flag = true;

            for (String[] pair : lts) {
                int v1 = value(pair[0], vmap);
                int v2 = value(pair[1], vmap);
                if (v1 >= v2) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (String[] pair : les) {
                    int v1 = value(pair[0], vmap);
                    int v2 = value(pair[1], vmap);
                    if (v1 > v2) {
                        flag = false;
                        break;
                    }
                }
            }

            System.out.println(flag ? "Yes" : "No");
        }
    }

    private static int value(String s, HashMap<String, Integer> vmap) {
        int v = 0;
        if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
            v = vmap.get(s);
        } else {
            v = Integer.valueOf(s);
        }
        return v;
    }
}
