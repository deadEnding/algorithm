package custom.company.alibaba.internship;


import java.util.LinkedList;

public class Main {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        break;
                }
            } else if (token.equals("^")) {
                if (stack.size() < 1) {
                    return -1;
                }
                stack.push(stack.pop() + 1);
            } else {
                if (stack.size() == 16) {
                    return -2;
                }
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        String[] token = {"2", "3", "4", "*" , "^", "5", "+"};
        System.out.println(new Main().evalRPN(token));
    }
}
