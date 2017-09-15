package custom.company.google.interview;

import java.util.HashSet;

public class ParenthesesMatch {

    private HashSet<Integer> set = new HashSet<>();

    private int count(String s) {
        int l = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else {
                count += l;
            }
        }
        return count;
    }

    private String ntime(char c, int n) {
        StringBuilder builder = new StringBuilder();
        while (n-- > 0) {
            builder.append(c);
        }
        return builder.toString();
    }

    public String solve(int n, int l) {
        int left = l / 2;
        int right = l - l / 2;
        int max = left * right;
        if (n > max) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int delta = max - n;

        int a = delta / left;
        builder.append(ntime(')', a));
        int b = left - delta % left;
        builder.append(ntime('(', b));
        builder.append(')');
        int c = left - b;
        builder.append(ntime('(', c));
        int d = right - a - 1;
        builder.append(ntime(')', d));

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = new ParenthesesMatch().solve(10, 9);
        System.out.println(s);
        System.out.println(new ParenthesesMatch().count(s));

    }
}
