package custom.company.microsoft.internship.Q201604.B;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 3:23 PM 30/03/2017
 */


public class Main {

    private static String f(String p) {
        String t = Integer.toBinaryString(Integer.valueOf(p));
        while (t.length() < 8) {
            t = "0" + t;
        }
        return t;
    }

    private static String format(String rule) {
        String[] ipMask = rule.split("/", -1);
        String ip = ipMask[0];
        String[] part = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String p : part) {
            builder.append(f(p));
        }
        if (ipMask.length == 1) {
            return builder.toString();
        }
        return builder.substring(0, Integer.valueOf(ipMask[1]));
    }

    private static void resolve(String[] rules, String[] ips) {
        HashMap<String, Integer>[] ruleTime = new HashMap[33];
        for (int i = 0; i < 33; i++) {
            ruleTime[i] = new HashMap<>();
        }

        for (int i = 0; i < rules.length; i++) {
            String[] parts = rules[i].split(" ");
            String prefix = format(parts[1]);
            int ix = prefix.length();
            if (!ruleTime[ix].containsKey(prefix)) {
                ruleTime[ix].put(prefix, (i + 1) * (parts[0].equals("allow") ? 1 : -1));
            }
        }

        for (String ip : ips) {
            int min = Integer.MAX_VALUE;
            String s = format(ip);
            for (int i = 0; i <= 32; i++) {
                String t = s.substring(0, i);
                if (ruleTime[i].containsKey(t)) {
                    if (Math.abs(ruleTime[i].get(t)) < Math.abs(min)) {
                        min = ruleTime[i].get(t);
                    }
                }
            }
            if (min < 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        String[] rules = new String[n];
        for (int i = 0; i < n; i++) {
            rules[i] = sc.nextLine();
        }

        String[] ips = new String[m];
        for (int i = 0; i < m; i++) {
            ips[i] = sc.nextLine();
        }

        resolve(rules, ips);
    }
}
