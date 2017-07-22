package leetcode.L593_ValidSquare;


public class Solution {
    private long distance(int[] p1, int[] p2) {
        return ((long)p1[0] - p2[0]) * ((long)p1[0] - p2[0]) + ((long)p1[1] - p2[1]) * ((long)p1[1] - p2[1]);
    }

    private boolean validTriangle(int[] p1, int[] p2, int[] p3) {
        long d1 = distance(p1, p2);
        long d2 = distance(p1, p3);
        long d3 = distance(p2, p3);
        return (d1 == d2 && d1 * 2 == d3) || (d1 == d3 && d1 * 2 == d2) || (d2 == d3 && d2 * 2 == d1);
    }

    private boolean equals(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (equals(p1, p2) || equals(p1, p3) || equals(p1, p4) ||
                equals(p2, p3) || equals(p2, p4) || equals(p3, p4)) {
            return false;
        }

        return validTriangle(p2, p3, p4) && validTriangle(p1, p3, p4) &&
                validTriangle(p1, p2, p4) && validTriangle(p1, p2, p3);
    }
}
