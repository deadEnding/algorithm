package leetcode.L223_RectangleArea;

/**
 * @author: deadend
 * @date: 12:24 AM 12/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x1 = Math.max(A, E);
        long y1 = Math.max(B, F);
        long x2 = Math.min(C, G);
        long y2 = Math.min(D, H);
        long area1 = ((long) D - B) * ((long) C - A);
        long area2 = ((long) G - E) * ((long) H - F);
        long area  = Math.max((long) x2 - x1, 0) * Math.max((long) y2 - y1, 0);
        return (int) (area1 + area2 - area);
    }
}
