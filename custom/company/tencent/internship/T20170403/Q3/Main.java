package custom.company.tencent.internship.T20170403.Q3;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 8:36 PM 03/04/2017
 * @desc: 输出文件的十六进制编码
 */


public class Main {

    public static String poffset(int offset) {
        String h = Integer.toHexString(offset);
        while (h.length() < 8) {
            h = "0" + h;
        }
        return h;
    }

    public static void resolve(String s) {
        char[] chs = s.toCharArray();
        final int n = chs.length;

        int offset = 0;
        int row = (int)Math.ceil((double)n / 16);

        for (int i = 0; i < row; i++) {
            if (i != 0)
                System.out.println();
            System.out.print(poffset(offset));
            offset += 16;
            System.out.print("  ");

            int j;
            for (j = i * 16; j < Math.min(n, i * 16 + 16); j++) {
                if (j - i * 16 == 8)
                    System.out.print(" ");
                System.out.print(Integer.toHexString(chs[j]).toLowerCase());
                System.out.print(" ");
            }

            System.out.print(" ");
            System.out.print(s.substring(i * 16, j));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        resolve(s);
    }
}
