package leetcode.L060_PermutationSequence;

/**
 * @author: deadend
 * @date: 9:26 AM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int factorial(int n) {
        return n <= 1 ? 1 : factorial(n - 1) * n;
    }

    private int getKth(boolean[] used, int k) {
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && k-- == 0) {
                return i;
            }
        }
        return -1;
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        StringBuilder builder = new StringBuilder();

        k--;
        for (int i = n - 1; i >= 0; i--) {
            int f = factorial(i);
            int ix = getKth(used, k / f);
            k %= f;
            used[ix] = true;
            builder.append(ix + 1);
        }

        return builder.toString();
    }
}


class OldSolution {
    private int factorial(int x) {
        return x <= 1 ? 1 : factorial(x - 1) * x;
    }


    private int findKth(boolean[] used, int k) {
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && k-- == 0) {
                return i;
            }
        }
        return -1;
    }

    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[n];
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int f = factorial(i);
            int kth = k / f;
            int ix = findKth(used, kth);
            builder.append(ix + 1);
            used[ix] = true;
            k %= f;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(2, 2));
    }
}
























class FirstSolution {

    private int findKth(boolean[] used, int k) {
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                if (k-- == 0) {
                    used[i] = true;
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private int factorial(int x) {
        int f = 1;
        while (x > 0) {
            f *= x--;
        }
        return f;
    }

    public String getPermutation(int n, int k) {
        k--;
        boolean[] used = new boolean[n];
        StringBuffer buffer = new StringBuffer();
        for (int i = n; i >= 1; i--) {
            if (i == 1) {
                buffer.append(findKth(used, 0) + 1);
            } else {
                int base = factorial(i - 1);
                int kth = findKth(used, k / base);
                k %= base;
                buffer.append(kth + 1);
            }
        }
        return buffer.toString();
    }
}
