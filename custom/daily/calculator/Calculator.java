package custom.daily.calculator;

import java.util.LinkedList;

public class Calculator {

    static class SignedStack extends LinkedList<Integer> {
        private char sign;

        public SignedStack(char sign) {
            this.sign = sign;
        }

        public char getSign() {
            return sign;
        }

        public int sum() {
            int sum = 0;
            for (int num : this) {
                sum += num;
            }
            return sum;
        }
    }

    public static int calculate(String s) {
        final int n = s.length();
        char sign = '+';
        LinkedList<SignedStack> stack = new LinkedList<>();

        stack.push(new SignedStack(sign));
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int v = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    v = v * 10 + s.charAt(++i) - '0';
                }

                SignedStack stk = stack.peek();
                switch (sign) {
                    case '+':
                        stk.push(v);
                        break;
                    case '-':
                        stk.push(-v);
                        break;
                    case '*':
                        stk.push(stk.pop() * v);
                        break;
                    case '/':
                        stk.push(stk.pop() / v);
                        break;
                    default:
                        break;
                }
            } else if (c == '(') {
                stack.push(new SignedStack(sign));
                sign = '+';
            } else if (c == ')') {
                SignedStack currStk = stack.pop();
                int sum = currStk.sum();

                SignedStack stk = stack.peek();
                switch (currStk.getSign()) {
                    case '+':
                        stk.push(sum);
                        break;
                    case '-':
                        stk.push(-sum);
                        break;
                    case '*':
                        stk.push(stk.pop() * sum);
                        break;
                    case '/':
                        stk.push(stk.pop() / sum);
                        break;
                    default:
                        break;
                }
            } else if (!Character.isSpaceChar(c)) {
                sign = c;
            }
        }

        return stack.pop().sum();
    }

    public static void main(String[] args) {
        String s = "3 * (3+5) * (1 + (2 + 2 * 3 - 1)) / 2";
        System.out.println(calculate(s));
    }
}
