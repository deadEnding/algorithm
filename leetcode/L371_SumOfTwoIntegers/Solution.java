package leetcode.L371_SumOfTwoIntegers;

/**
 * @author: deadend
 * @date: 9:58 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;
        return carry == 0 ? xor : getSum(xor, carry << 1);
    }

    public static void main(String[] args) {
        System.out.println(new ItertiveSolution().getSum(-1, 2));
    }
}

class ItertiveSolution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
