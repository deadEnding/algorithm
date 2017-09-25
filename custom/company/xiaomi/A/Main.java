package custom.company.xiaomi.A;

import java.util.Scanner;

public class Main {

    private static String convert(String s) {
        if (s.equals("")) {
            return "";
        }

        char c = s.charAt(0);
        StringBuilder builder = new StringBuilder();
        if (Character.isDigit(c)) {
            int ix = 0;
            while (ix < s.length() && Character.isDigit(s.charAt(ix))) {
                builder.append(Character.toUpperCase(s.charAt(ix)));
                ix++;
            }
            return builder.toString() + "_" + convert(s.substring(ix));
        } else if (Character.isLowerCase(c)) {
            int ix = 0;
            while (ix < s.length() && Character.isLetter(s.charAt(ix)) && Character.isLowerCase(s.charAt(ix))) {
                builder.append(Character.toUpperCase(s.charAt(ix)));
                ix++;
            }
            return builder.toString() + "_" + convert(s.substring(ix));
        } else {
            int ix = 0;
            while (ix < s.length() && Character.isLetter(s.charAt(ix)) && Character.isUpperCase(s.charAt(ix))) {
                builder.append(Character.toUpperCase(s.charAt(ix)));
                ix++;
            }

            if (ix == s.length()) {
                return s + "_";
            }

            if (Character.isDigit(s.charAt(ix))) {
                return s.substring(0, ix) + "_" + convert(s.substring(ix));
            } else {
                if (ix == 1) {
                    return c + convert(s.substring(1));
                } else {
                    return s.substring(0, ix - 1) + "_" + convert(s.substring(ix - 1));
                }
            }
        }

    }

    public static String solve(String s) {
        if (s.contains(".")) {
            String result = "_";
            for (int i = 0, start = 0; i <= s.length(); i++) {
                char c = i < s.length() ? s.charAt(i) : '.';
                if (c == '.') {
                    result += convert(s.substring(start, i));
                    start = i + 1;
                }
            }
            return result;
        }

        return "_" + convert(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("");
            } else {
                System.out.println(solve(s));
            }
        }
    }
}
