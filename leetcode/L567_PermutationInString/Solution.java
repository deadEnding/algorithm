package leetcode.again.L567_PermutationInString;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int count = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (counter.containsKey(c)) {
                if (counter.get(c) > 0) {
                    count--;
                }
                counter.put(c, counter.get(c) - 1);
            }

            if (i >= s1.length()) {
                char oc = s2.charAt(i - s1.length());
                if (counter.containsKey(oc)) {
                    if (counter.get(oc) >= 0) {
                        count++;
                    }
                    counter.put(oc, counter.get(oc) + 1);
                }
            }

            if (count == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "cba";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }
}
