package hihocoder.practice.P12.Q1;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 10:59 AM 03/04/2017
 */


public class Main {

    public static boolean isPrim(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i + i <= n; i++) {
            if (isPrim(i) && isPrim(n - i)) {
                System.out.println(i + " " + (n - i));
                break;
            }
        }
    }
}
