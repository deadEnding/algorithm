package leetcode.again.L273_IntegerToEnglishWords;


public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    private String repr(String s) {
        return s.equals("") ? "" : " " + s;
    }

    private String toWords(int num) {
        if (num <= 20) {
            return LESS_THAN_20[num];
        } else if (num < 100) {
            int m = num / 10, l = num % 10;
            return TENS[m] + repr(LESS_THAN_20[l]);
        } else {
            int h = num / 100;
            return LESS_THAN_20[h] + " Hundred" + repr(toWords(num % 100));
        }
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String result = "";
        int ix = 0;
        while (num != 0) {
            int t = num % 1000;
            if (t != 0) {
                result = toWords(t) +  repr(THOUSANDS[ix]) + repr(result);
            }
            num /= 1000;
            ix++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberToWords(40));
    }
}
