package leetcode.again.L537_ComplexNumberMultiplication;

/**
 * @author: deadend
 * @date: 9:38 PM 01/04/2017
 */


public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int i1 = a.indexOf('+');
        int a1 = Integer.valueOf(a.substring(0, i1));
        int b1 = Integer.valueOf(a.substring(i1 + 1, a.length() - 1));
        int i2 = b.indexOf('+');
        int a2 = Integer.valueOf(b.substring(0, i2));
        int b2 = Integer.valueOf(b.substring(i2 + 1, b.length() - 1));
        int na = a1 * a2 - b1 * b2;
        int nb = a1 * b2 + a2 * b1;
        return String.format("%d+%di", na, nb);
    }

    public static void main(String[] args) {
        String a = "1+-1i";
        String b = "1+-1i";
        System.out.println(new Solution().complexNumberMultiply(a, b));
    }
}
