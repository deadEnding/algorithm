package leetcode.again.L484_FindPermutation;

/**
 * @author: deadend
 * @date: 9:43 AM 3/12/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    private void swap(int[] p, int i, int j) {
        int t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    private void reverse(int[] p, int s, int e) {
        while (s < e) {
            swap(p, s++, e--);
        }
    }

    public int[] findPermutation(String s) {
        final int n = s.length();
        int[] p = new int[n + 1];

        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            int start = i;
            if (s.charAt(i) == 'D') {
                while (i + 1 < n && s.charAt(i + 1) == 'D') {
                    i++;
                }
                reverse(p, start, i + 1);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] p = new Solution().findPermutation(s);
        for (int i : p) {
            System.out.print(i + " ");
        }
    }
}

class BasicSolution {
    private void swap(int[] p, int i, int j) {
        int t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    public int[] findPermutation(String s) {
        final int n = s.length();
        int[] p = new int[n + 1];

        for (int i = 0; i < p.length; i++) {
            p[i] = i + 1;
        }

        for (int i = 0; i < p.length - 1; i++) {
            int j = i;
            while (j >= 0 && (s.charAt(j) == 'D' && p[j] < p[j + 1] || s.charAt(j) == 'I' && p[j] > p[j + 1])) {
                swap(p, j, j + 1);
                j--;
            }
        }
        return p;
    }
}
