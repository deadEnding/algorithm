package custom.codinginterviews.CH6;

/**
 * @author: deadend
 * @date: 2:45 PM 2/7/17
 * @version: 1.0
 * @description:
 */


public class JosephuseCircle {

    public int solution1(int n, int m) {
        boolean[] out = new boolean[n];
        for (int i = 0, ix = 0; i < n - 1; i++) {
            int j = 0;
            while (j < m) {
                ix %= n;
                if (!out[ix++]) {
                    j++;
                }
            }
            out[(ix - 1 + n) % n] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!out[i]) {
                return i;
            }
        }
        return -1;
    }

    public int solution2(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new JosephuseCircle().solution1(5, 3));
        System.out.println(new JosephuseCircle().solution2(5, 3));
    }
}
