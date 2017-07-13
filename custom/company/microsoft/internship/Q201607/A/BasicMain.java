package custom.company.microsoft.internship.Q201607.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 10:56 PM 30/03/2017
 */


public class BasicMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] eq = new String[n];
        ArrayList<String>[] vars = new ArrayList[n];
        ArrayList<String>[] ops = new ArrayList[n];
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            eq[i] = sc.nextLine();
            vars[i] = new ArrayList<>();
            ops[i] = new ArrayList<>();

            ops[i].add("<=");
            int len = eq[i].length();
            for (int j = 0; j < len; j++) {
                char c = eq[i].charAt(j);
                if (Character.isLetter(c)) {
                    vars[i].add(c + "");
                    set.add(c);
                } else if (Character.isDigit(c)) {
                    String d = "" + c;
                    while (j + 1 < len && Character.isDigit(eq[i].charAt(j + 1))) {
                        d += eq[i].charAt(++j);
                    }
                    vars[i].add(d);
                } else {
                    String op = "" + c;
                    if (j + 1 < len && eq[i].charAt(j + 1) == '=') {
                        op += '=';
                        j++;
                    }
                    ops[i].add(op);
                }
            }
        }


        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 0; c < cases; c++) {
            HashMap<String, Integer> vmap = new HashMap<>();
            for (int i = 0; i < set.size(); i++) {
                String[] parts = sc.nextLine().split(" ");
                vmap.put(parts[0], Integer.valueOf(parts[1]));
            }

            boolean flag = true;

            for (int i = 0; i < n; i++) {
                int last = Integer.MIN_VALUE;
                for (int j = 0; j < vars[i].size(); j++) {
                    int v = 0;
                    if (vars[i].get(j).length() == 1 && Character.isLetter(vars[i].get(j).charAt(0))) {
                        v = vmap.get(vars[i].get(j));
                    } else {
                        v = Integer.valueOf(vars[i].get(j));
                    }

                    if (ops[i].get(j).equals("<") && last >= v || ops[i].get(j).equals("<=") && last > v) {
                        flag = false;
                        break;
                    }
                    last = v;
                }
            }

            System.out.println(flag ? "Yes" : "No");
        }
    }
}
