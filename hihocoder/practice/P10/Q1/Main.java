package hihocoder.practice.P10.Q1;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:55 AM 3/19/17
 * @version: 1.0
 * @description:
 */


public class Main {

    private static boolean resolve(String s) {
        int acount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            acount += c == 'A' ? 1 : 0;
            if (acount > 1) {
                return false;
            }

            if (i >= 2 && s.charAt(i - 2) == 'L' && s.charAt(i - 1) == 'L' && c == 'L') {
                return false;
            }
        }
        return true;
    }

    private static void test() {
        char[] tmp = {'O', 'L', 'A'};
        int count = 0;
        for (int i1 = 0; i1 < 3; i1++) {
            for (int i2 = 0; i2 < 3; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    for (int i4 = 0; i4 < 3; i4++) {
                        for (int i5 = 0; i5 < 3; i5++) {
                            for (int i6 = 0; i6 < 3; i6++) {
                                char[] chs = {tmp[i1], tmp[i2], tmp[i3], tmp[i4], tmp[i5], tmp[i6]};
                                count += resolve(new String(chs)) ? 1 : 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int cases = Integer.valueOf(sc.nextLine());
//        for (int c = 0; c < cases; c++) {
//            String line = sc.nextLine();
//            boolean ret = resolve(line.trim());
//            System.out.println(ret ? "YES" : "NO");
//        }
        test();
    }
}
