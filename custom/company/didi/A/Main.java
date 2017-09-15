package custom.company.didi.A;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<>();
        while (in.hasNextInt()) {
            numList.add(in.nextInt());
        }

        int dp = 0, max = Integer.MIN_VALUE;
        for (int num : numList) {
            dp = Math.max(num, dp + num);
            max = Math.max(max, dp);
        }
        System.out.println(max);
    }
}


