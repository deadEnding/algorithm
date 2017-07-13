package custom.company.BUPT.warmup.R2.E;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 4:43 PM 29/03/2017
 */


public class Main {

    private static String resolve(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '1') {
                builder.append('1');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        for (int c = 0; c < cases; c++) {
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(resolve(s));
        }
    }
}
