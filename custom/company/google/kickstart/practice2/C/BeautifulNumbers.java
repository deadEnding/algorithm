package custom.company.google.kickstart.practice2.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BeautifulNumbers {

    public static long smallestGoodBase(long num) {
        // 求num数值2进制对应的位数，即最大位数，因此进制越大，位数越小
        int maxBits = 0;
        for (long t = num; t != 0; t >>= 1) {
            maxBits++;
        }

        // 位数由大到小进行测试，一旦合法立即返回
        for (int bits = maxBits; bits >= 2; bits--) {
            long k = helper(num, bits);
            if (k != -1) {
                return k;
            }
        }
        return num - 1L;
    }

    // 是否存在x进制使得bits个1的值等于num，存在则返回x，否则返回-1
    public static long helper(long num, int bits) {
        // 确定进制的上届，若直接r = num - 1会溢出
        long l = 2, r = (long) (Math.pow(num, 1.0 / (bits - 1)) + 1);
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i < bits; i++) {
                sum += cur;
                cur *= m;
            }

            if (sum == num) {
                return m;
            } else if (sum < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {

//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-small-practice.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-large-practice.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
            long n = sc.nextLong();
            System.out.println(String.format("Case #%d: %d", _c, smallestGoodBase(n)));
        }
    }
}
