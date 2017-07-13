package custom.company.microsoft.recruitment.Q201610.A;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 3:23 PM 31/03/2017
 */


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int delta = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            delta += num % 2 == 0 ? 1 : -1;
        }
        System.out.println(Math.abs(delta));
    }
}
