package leetcode.L008_StringToInteger_Atoi;

/**
 * @author: deadend
 * @date: 1:02 PM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int myAtoi(String str) {
        // Start typing your Java solution below
        // DO NOT write Main() function
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
            
        int sign = 1;
        int index = 0;
    
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }   
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }

    public static void main(String[] args) {
        String s = "  +-123^";
        System.out.println(new Solution().myAtoi(s));
    }
}
