package leetcode.again.L592_FractionAdditionAndSubtraction;


import java.util.ArrayList;

public class Solution {

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long lcm(long base, int ix, ArrayList<Long> nums) {
        if (ix == nums.size()) {
            return base;
        }

        return lcm(lcm(base, nums.get(ix)), ix + 1, nums);
    }

    public String fractionAddition(String expression) {
        if (!expression.startsWith("+") && !expression.startsWith("-")) {
            expression = "+" + expression;
        }

        ArrayList<Long> numes = new ArrayList<>();
        ArrayList<Long> denos = new ArrayList<>();

        for (int i = 1, start = 0, slash = 0; i <= expression.length(); i++) {
            char c = i < expression.length() ? expression.charAt(i) : '+';
            if (c == '/') {
                slash = i;
            } else if (c == '+' || c == '-') {
                numes.add(Long.valueOf(expression.substring(start, slash)));
                denos.add(Long.valueOf(expression.substring(slash + 1, i)));
                start = i;
            }
        }

        long d = lcm(1L, 0, denos);
        long n = 0L;
        for (int i = 0; i < numes.size(); i++) {
            n += numes.get(i) * (d / denos.get(i));
        }

        long gcd = gcd(Math.abs(n), d);
        return (n / gcd) + "/" + (d / gcd);
    }

    public static void main(String[] args) {
        String exp = "1/3-1/2";
        System.out.println(new Solution().fractionAddition(exp));
    }
}
