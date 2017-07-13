package custom.company.tencent.internship.T20170403.Q4;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 9:30 PM 03/04/2017
 * @desc: 求满二叉搜索树中三个节点的LCA
 */


public class Main {

    public static int binarySearch(int a,int b,int c, int left, int right) {
        int m = left + (right - left) / 2;

        if((a - m) * (b - m) <= 0 || (a - m) * (c - m) <= 0 || (c - m) * (b - m) <= 0) {
            return m;
        } else if(a > m) {
            return binarySearch(a, b, c, m + 1, right);
        } else {
            return binarySearch(a, b, c, left, m - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(binarySearch(a, b, c, 1, (2 << k) - 1));
    }
}
