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
