package custom.company.microsoft.internship.Q201703.D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Other {
    private static int counter = 0;

    private static void backtracking(List<Integer> rl, List<Integer> sl,
                                     int idx, int lowerBound) {
        if(rl.size() == idx) {
            ++counter;
        } else {
            int r = lowerBound;
            while(r <= rl.get(idx)) {
                backtracking(rl, sl, idx + 1, r);
                ++r;
            }
        }
    }


    private static int[] helper(String s) {
        if (s.length() == 0)
            return null;
        int[] dp = new int[s.length()];
        dp[0] = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0
                    && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            } else {
                dp[i] = 0;
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int[] dp = helper(s);
            List<String> temp = new ArrayList<>();

            for (int i = dp.length - 1; i >= 0; --i) {
                if (dp[i] != 0) {
                    int j = i - dp[i] + 1;
                    temp.add("cmplx");
                    i = j;
                } else {
                    temp.add("r");
                }
            }

            List<Integer> sl = new ArrayList<>();
            List<Integer> rl = new ArrayList<>();

            for (int i = temp.size() - 1; i >= 0; --i) {
                if (temp.get(i).equals("r")) {
                    rl.add(temp.size() - 1 - i);
                }
                sl.add(temp.size() - 1 - i);
            }
            backtracking(rl, sl, 0, 0);
            System.out.println(rl.size() + " " + counter);
        }
    }
}
