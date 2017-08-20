package leetcode.L411_MinimumUniqueWordAbbreviation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 8:38 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String result;

    private boolean isValidAbbr(String word, String abbr) {
        int i = 0, j = 0;

        while (i < word.length() && j < abbr.length()) {
            char wc = word.charAt(i);
            char ac = abbr.charAt(j);
            if (wc == ac) {
                i++;
                j++;
            } else if (Character.isLetter(ac)) {
                return false;
            } else {
                if (ac == '0') {
                    return false;
                }

                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + abbr.charAt(j++) - '0';
                }

                i += num;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    private void getAbbreviation(int ix, String s, int count, String path, ArrayList<String> dict) {
        if (ix == s.length()) {
            String abbr = path + (count > 0 ? count : "");
            boolean notConflict = true;
            for (String w : dict) {
                if (isValidAbbr(w, abbr)) {
                    notConflict = false;
                    break;
                }
            }

            if (notConflict && (result == null || result.length() > abbr.length())) {
                result = abbr;
            }
        } else {
            getAbbreviation(ix + 1, s, count + 1, path, dict);
            getAbbreviation(ix + 1, s, 0, path + (count > 0 ? count : "") + s.charAt(ix), dict);
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {
        ArrayList<String> dict = new ArrayList<>();
        for (String word : dictionary) {
            if (target.length() == word.length()) {
                dict.add(word);
            }
        }

        getAbbreviation(0, target, 0, "", dict);
        return result;
    }

    public static void main(String[] args) {
        String target = "apple";
        String[] dict = {"plain", "amber", "blade"};
        System.out.println(new Solution().minAbbreviation(target, dict));
    }
}


class TimeoutSolution {
    private void getAbbreviation(int ix, String s, int count, String path, HashSet<String> set) {
        if (ix == s.length()) {
            set.add(path + (count > 0 ? count : ""));
        } else {
            getAbbreviation(ix + 1, s, count + 1, path, set);
            getAbbreviation(ix + 1, s, 0, path + (count > 0 ? count : "") + s.charAt(ix), set);
        }
    }

    private int getLength(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || Character.isLetter(s.charAt(i)) || Character.isLetter(s.charAt(i - 1))) {
                len++;
            }
        }
        return len;
    }

    public String minAbbreviation(String target, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for (String d : dictionary) {
            getAbbreviation(0, d, 0, "", set);
        }

        ArrayList<String> abbr = new ArrayList<>();
        HashSet<String> tset = new HashSet<>();
        getAbbreviation(0, target, 0, "", tset);
        abbr.addAll(tset);
        Collections.sort(abbr, (a1, a2) -> (getLength(a1) - getLength(a2)));
        for (int i = 0; i < abbr.size(); i++) {
            if (!set.contains(abbr.get(i))) {
                return abbr.get(i);
            }
        }
        return null;
    }
}
