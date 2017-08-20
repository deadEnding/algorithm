package custom.company.google.interview;

import java.util.HashMap;

/**
 * 给定一个只有小写字母的字符串，问有多少连续子序列（子串）中每个字符不重复出现
 */
public class NumberOfSubStringWithoutDumplicate {

    public int solve(String s) {
        int count = 0;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0, start = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            count += i - Math.max(lastIndex.getOrDefault(c, -1), start);
            if (lastIndex.containsKey(c)) {
                start = lastIndex.get(c);
            }
            lastIndex.put(c, i);
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new NumberOfSubStringWithoutDumplicate().solve(s));
    }
}
