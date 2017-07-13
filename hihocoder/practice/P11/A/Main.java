package hihocoder.practice.P11.A;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 12:56 PM 04/04/2017
 */


public class Main {

    public static boolean match(int[] cnt) {
        return cnt['h' - 'a'] == 2 && cnt['i' - 'a'] == 1 && cnt['o' - 'a'] == 1;
    }

    public static int resolve(String s) {
        int[] cnt = new int[26];
        int min = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && (cnt['h' - 'a'] < 2 || cnt['i' - 'a'] < 1 || cnt['o' - 'a'] < 1)) {
                cnt[s.charAt(r) - 'a']++;
                r++;
            }

            if (match(cnt)) {
                min = Math.min(min, r - l);
            }
            cnt[s.charAt(l) - 'a']--;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(resolve(s));
    }
}
