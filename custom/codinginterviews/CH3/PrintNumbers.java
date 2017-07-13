package custom.codinginterviews.CH3;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 9:32 PM 2/5/17
 * @version: 1.0
 * @description:
 */


public class PrintNumbers {

    public void print(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1);
        while (digits.size() <= n) {
            System.out.println(getNumber(digits));
            add(digits);
        }
    }

    private void add(ArrayList<Integer> digits) {
        int c = 1;
        for (int i = 0; i < digits.size(); i++) {
            int tmp = digits.get(i) + c;
            digits.set(i, tmp % 10);
            if ((c = tmp / 10) == 0) {
                break;
            }
        }
        if (c == 1) {
            digits.add(1);
        }
    }

    private String getNumber(ArrayList<Integer> digits) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digits.size(); i++) {
            sb.insert(0, digits.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new PrintNumbers().print(7);
    }
}
