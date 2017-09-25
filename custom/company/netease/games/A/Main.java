package custom.company.netease.games.A;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static String format(String nh, String nm, String ns) {
        return nh + ":" + nm + ":" + ns;
    }

    public static boolean valid(String s) {
        int hh = Integer.valueOf(s.substring(0, 2));
        int mm = Integer.valueOf(s.substring(3, 5));
        int ss = Integer.valueOf(s.substring(6));
        return 0 <= hh && hh <= 23 && 0 <= mm && mm <= 59 && 0 <= ss && ss <= 59;
    }

    public static String solve(String ori) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(ori);
        queue.offer(null);

        HashSet<String> visited = new HashSet<>();
        visited.add(ori);

        String min = null;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s == null) {
                if (min == null) {
                    queue.offer(null);
                } else {
                    break;
                }
                continue;
            }

            if (valid(s)) {
                if (min == null || min.compareTo(s) > 0) {
                    min = s;
                }
            }

            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != ':') {
                    char oc = chs[i];
                    for (char c = '0'; c <= '9'; c++) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (!visited.contains(t)) {
                            visited.add(t);
                            queue.offer(t);
                        }
                    }
                    chs[i] = oc;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cs = Integer.valueOf(sc.nextLine());
        for (int _c = 0; _c < cs; _c++) {
            String line = sc.nextLine();
            System.out.println(solve(line));
        }
    }
}
