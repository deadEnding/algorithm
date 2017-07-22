package leetcode.L223_RectangleArea;

/**
 * @author: deadend
 * @date: 6:30 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        long area = ((long)C - A) * ((long)D - B) + ((long)G - E) * ((long)H - F);
        if (bottom < top && left < right) {
            return (int)(area - ((long)top - bottom) * ((long)right - left));
        } else {
            return (int)area;
        }
    }

    public static void main(String[] args) {
        int A = -2, B = -2, C = 2, D = 2;
        int E = -1, F = -1, G = 1, H = 1;
        System.out.println(new Solution().computeArea(A,B,C,D,E,F,G,H));
    }
}
