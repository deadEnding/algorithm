package custom.company.microsoft.internship.Q201703.A;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 9:23 PM 31/03/2017
 */


public class Other {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();
            int n = in.nextInt();
            double lastResult = 0;
            for (int i = n;i > 0; i--) {
                double current = 0;
                double lastPercent = 1;
                for (int j = 0; p/(Math.pow(2,i-1)) + q * j < 100.0 + q;j++) {
                    double nowPercent = (p/(Math.pow(2,i-1)) + q * j)> 100.0 ? 100 : (p/(Math.pow(2,i-1)) + q * j);
                    current += (j+1+lastResult) * lastPercent * nowPercent/ 100;
                    lastPercent *= 1.0 - nowPercent/ 100;
                }
                lastResult = current;
            }

            System.out.println(String.format("%.2f", lastResult));
        }
    }
}
