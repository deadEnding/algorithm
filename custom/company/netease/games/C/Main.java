package custom.company.netease.games.C;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        long[] times = new long[n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            times[i] = sdf.parse(line.substring(0, 19)).getTime();
            sum[i + 1] = sum[i] + Integer.valueOf(line.substring(20));
        }


        int m = Integer.valueOf(sc.nextLine());
        System.gc();
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            int six = Arrays.binarySearch(times, sdf.parse(line.substring(0, 19)).getTime());
            six = six < 0 ? -six - 1 - 1 : six - 1;
            int eix = Arrays.binarySearch(times, sdf.parse(line.substring(20)).getTime());
            eix = eix < 0 ? -eix - 1 - 1 : eix;

            System.out.println(sum[eix + 1] - sum[six + 1]);
        }
    }
}
