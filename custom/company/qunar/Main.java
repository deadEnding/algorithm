package custom.company.qunar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] x = new int[n][3];
        for (int i = 0; i < n; i++) {
            int sum = 0, min = 6;
            for (int j = 0; j < 5; j++) {
                int k = sc.nextInt();
                min = Math.min(min, k);
                sum += k;
            }
            x[i][0] = min;
            x[i][1] = sum;
            x[i][2] = i;
        }

        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o2[0] - o1[0];

                if (o1[1] != o2[1])
                    return o2[1] - o1[1];

                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < n; i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(x[i][2]);
        }
    }
}
