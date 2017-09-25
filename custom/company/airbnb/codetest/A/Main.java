package custom.company.airbnb.codetest.A;

import java.util.HashMap;

public class Main {

    static String minimumSubstring(String s, String alphabet) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : alphabet.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String res = null;
        for (int l = 0, r = 0, count = alphabet.length(); r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (res == null || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }

                char sc = s.charAt(l++);
                if (map.containsKey(sc)) {
                    map.put(sc, map.get(sc) + 1);
                    if (map.get(sc) > 0) {
                        count++;
                    }
                }
            }
        }

        return res == null ? "" : res;
    }

    public static void main(String[] args) {
        System.out.println(minimumSubstring("daadcbddbadac", "abc"));
    }

}
