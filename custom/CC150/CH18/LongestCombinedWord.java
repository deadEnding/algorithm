package custom.CC150.CH18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 4:23 PM 1/5/17
 * @version: 1.0
 * @description: 给定单词数组，求其中最长的单词，且该单词由数组内其他单词组合而成。
 */


public class LongestCombinedWord {

    private boolean canBeBuilt(String word, boolean isOriginalWord, HashMap<String, Boolean> map) {
        if (!isOriginalWord && map.containsKey(isOriginalWord)) {
            return map.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (canBeBuilt(left, false, map) && canBeBuilt(right, false, map)) {
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }

    public String getLongestWord(String[] arr) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, true);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (String s : arr) {
            if (canBeBuilt(s, true, map)) {
                return s;
            }
        }
        return null;
    }
}
