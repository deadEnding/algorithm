package custom.company.google.interview;



public interface BigNumberAddition {
    public String sumOf(String num1, String num2);
}

/*

// Wrong
class BigNumberAdditionComplementalSolution implements BigNumberAddition{

    static class ComplemntalNumber {
        String cnum;

        private ComplemntalNumber(String cnum) {
            this.cnum = cnum;
        }

        private static String cleanUp(String num) {
            return num.startsWith("+") || num.startsWith("-") ? num.substring(1) : num;
        }

        public static ComplemntalNumber from(String num) {
            int sign = num.startsWith("-") ? 9 : 0;
            num = cleanUp(num);
            return new ComplemntalNumber(sign + (sign == 9 ? transfer(num) : num));
        }

        public static String transfer(String num) {
            final int n = num.length();
            StringBuilder builder = new StringBuilder();
            for (int i = n - 1, c = 1; i >= 0; i--) {
                int s = 9 - (num.charAt(i) - '0') + c;
                builder.insert(0, s % 10);
                c = s / 10;
            }

            return builder.toString();
        }

        public int length() {
            return cnum.length();
        }

        public char charAt(int i) {
            return cnum.charAt(i);
        }

        public static String sumOf(String rawNum1, String rawNum2) {
            ComplemntalNumber num1 = ComplemntalNumber.from(rawNum1);
            ComplemntalNumber num2 = ComplemntalNumber.from(rawNum2);
            final int n1 = num1.length();
            final int n2 = num2.length();

            System.out.println(num1.cnum);
            System.out.println(num2.cnum);

            StringBuilder builder = new StringBuilder();
            int c = 0;
            for (int i = n1 - 1, j = n2 - 1; i >= 1 || j >= 1;) {
                int a = i >= 1 ? num1.charAt(i--) - '0' : 0;
                int b = j >= 1 ? num2.charAt(j--) - '0' : 0;
                int s = a + b + c;
                builder.insert(0, s % 10);
                c = s / 10;
            }

            builder.insert(0, (num1.charAt(0) - '0' + num2.charAt(0) - '0' + c) % 10);

            String s = builder.toString();
            if (s.charAt(0) == '9' || s.charAt(0) == '8') {
                return "-" + transfer(s.substring(1));
            } else if (s.charAt(0) == 0) {
                return s.substring(1);
            } else {
                return s;
            }
        }
    }

    @Override
    public String sumOf(String num1, String num2) {
        return ComplemntalNumber.sumOf(num1, num2);
    }
}

*/

/**
 * 正负大整数加法
 * 1. 加减法中进位、借位最后加入到结果
 * 2. 减法存在前导零问题
 */
class BigNumberAdditionBasicSolution implements BigNumberAddition{

    @Override
    public String sumOf(String num1, String num2) {
        int sign1 = signOf(num1);
        int sign2 = signOf(num2);
        num1 = cleanUp(num1);
        num2 = cleanUp(num2);
        String sign;
        String ans;
        if (sign1 * sign2 == 1) {
            sign = sign1 == 1 ? "+" : "-";
            ans = addition(num1, num2);
        } else {
            if (largerThanOrEqual(num1, num2)) {
                sign = sign1 == 1 ? "+" : "-";
                ans = difference(num1, num2);
            } else {
                sign = sign2 == 1 ? "+" : "-";
                ans = difference(num2, num1);
            }
        }

        return (sign.equals("+") ? "" : sign) + ans;
    }

    private int signOf(String num) {
        return num.startsWith("-") ? -1 : 1;
    }

    private String cleanUp(String num) {
        return num.startsWith("+") || num.startsWith("-") ? num.substring(1) : num;
    }

    private boolean largerThanOrEqual(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return true;
        } else if (num1.length() < num2.length()) {
            return false;
        } else {
            return num1.compareTo(num2) >= 0;
        }
    }

    private String addition(String num1, String num2) {
        final int n1 = num1.length();
        final int n2 = num2.length();

        StringBuilder builder = new StringBuilder();
        int c = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >=0;) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int s = a + b + c;
            builder.insert(0, s % 10);
            c = s / 10;
        }

        if (c > 0) {
            builder.insert(0, c);
        }

        return builder.toString();
    }

    private String difference(String num1, String num2) {
        final int n1 = num1.length();
        final int n2 = num2.length();

        StringBuilder builder = new StringBuilder();
        int c = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >=0;) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int s = a - b - c;
            builder.insert(0, (s + 10) % 10);
            c = s < 0 ? 1 : 0;
        }

        if (c > 0) {
            builder.insert(0, c);
        }

        // 去除前导零
        int start = 0;
        while (start < builder.length() && builder.charAt(start) == '0') {
            start++;
        }
        return start == builder.length() ? "0" : builder.substring(start);
    }

    public static void main(String[] args) {
        String[][] ss = {{"3","8"}, {"8","3"}, {"12", "-9"}, {"-12", "9"}, {"-3", "-8"}, {"3", "-3"}};
//        String[][] ss = {{"-8", "-3"}};
        BigNumberAddition bigNumberAddition = new BigNumberAdditionBasicSolution();
        for (String[] s : ss) {
            System.out.print(s[0] + " + " + s[1] + " = ");
            System.out.println(bigNumberAddition.sumOf(s[0], s[1]));
        }
    }
}
