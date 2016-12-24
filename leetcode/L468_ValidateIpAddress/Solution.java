package leetcode.L468_ValidateIpAddress;

/**
 * @author: deadend
 * @date: 6:03 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int count(String IP, char c) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }
    private boolean isValidIPv4(String IP) {
        if (count(IP, '.') != 3) {
            return false;
        }

        String[] slugs = IP.split("\\.");
        if (slugs.length != 4) {
            return false;
        }

        for (String s : slugs) {
            if (s.length() == 0 || s.length() > 3) {
                return false;
            }

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }

            if (Integer.valueOf(s) > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String IP) {
        if (count(IP, ':') != 7) {
            return false;
        }
        String[] slugs = IP.split(":");
        if (slugs.length != 8) {
            return false;
        }

        for (String s : slugs) {
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c) && !Character.isLetter(c)) {
                    return false;
                }

                if (Character.isLetter(c) && Character.toLowerCase(c) > 'f') {
                    return false;
                }
            }
        }
        return true;
    }

    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        }

        if (isValidIPv6(IP)) {
            return "IPv6";
        }

        return "Neither";
    }

    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    }
}
