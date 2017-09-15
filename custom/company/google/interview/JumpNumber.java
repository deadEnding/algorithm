package custom.company.google.interview;

import java.util.*;

/**
 * http://practice.geeksforgeeks.orog/problems/jumping-numbers/0
 * BFS
 */
public class JumpNumber {

    public static List<Integer> create(int max) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= Math.min(max, 9); i++) {
            result.add(i);
        }

        if (max <= 9) {
            return result;
        }

        for (int ix = 1; true; ix++) {
            int num = result.get(ix);
            for (int child : getChildren(num)) {
                if (child >= max) {
                    return result;
                }

                result.add(child);
            }
        }
    }

    private static List<Integer> getChildren(int num) {
        List<Integer> children = new ArrayList<>();

        int lastDigit = num % 10;
        if (lastDigit >= 1) {
            children.add(num * 10 + lastDigit - 1);
        }

        if (lastDigit <= 8) {
            children.add(num * 10 + lastDigit + 1);
        }

        return children;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- > 0) {
            List<Integer> result = create(scanner.nextInt());
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) {
                    System.out.print(" " + result.get(i));
                } else {
                    System.out.print(result.get(i));
                }
            }
        }
    }
}
