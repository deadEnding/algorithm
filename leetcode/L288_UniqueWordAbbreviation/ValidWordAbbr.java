package leetcode.again.L288_UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 2:45 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class ValidWordAbbr {

    private HashMap<String, String> map = new HashMap<>();

    private String getKey(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    public ValidWordAbbr(String[] dictionary) {
        for (String w : dictionary) {
            String key = getKey(w);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(w)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, w);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }

    public static void main(String[] args) {
        String[] d = {"a", "a"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(d);
        System.out.println(validWordAbbr.isUnique("a"));
    }
}
