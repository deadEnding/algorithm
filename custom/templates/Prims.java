package custom.templates;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 8:55 PM 02/04/2017
 */


public class Prims {

    public boolean isPrim(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean[] createPrimsLessThanN(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
