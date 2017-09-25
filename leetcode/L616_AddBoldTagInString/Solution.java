package leetcode.L616_AddBoldTagInString;


import java.util.HashSet;


class Solution {
    public String addBoldTag(String s, String[] dict) {
        final int n = s.length();
        boolean[] bold = new boolean[n];

        int end = 0;
        for (int i = 0; i < n; i++) {
            for (String w : dict) {
                if (s.substring(i).startsWith(w)) {
                    end = Math.max(end, i + w.length());
                }
            }
            bold[i] = end > i;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((i == 0 || !bold[i - 1]) && bold[i]) {
                builder.append("<b>");
                builder.append(s.charAt(i));
            } else if ((i - 1 >= 0 && bold[i - 1]) && !bold[i]) {
                builder.append("</b>");
                builder.append(s.charAt(i));
            } else {
                builder.append(s.charAt(i));
            }

            if (bold[i] && i == n - 1) {
                builder.append("</b>");
            }
        }

        return builder.toString();
    }
}


// Timeout
class TimeoutSolution {
    public String addBoldTag(String s, String[] dict) {
        final int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (String d : dict) {
            set.add(d);
        }

        boolean[] wrapped = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                String t = s.substring(i, j);
                if (set.contains(t)) {
                    for (int k = i; k < j; k++) {
                        wrapped[k] = true;
                    }
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wrapped.length; i++) {
            if ((i == 0 || !wrapped[i - 1]) && wrapped[i]) {
                builder.append("<b>");
                builder.append(s.charAt(i));
            } else if ((i - 1 >= 0 && wrapped[i - 1]) && !wrapped[i]) {
                builder.append("</b>");
                builder.append(s.charAt(i));
            } else {
                builder.append(s.charAt(i));
            }

            if (wrapped[i] && i == n - 1) {
                builder.append("</b>");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
//        String s = "abcxyz123";
//        String[] dict = {"abc","123"};
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};
        System.out.println(new Solution().addBoldTag(s, dict));
    }
}
