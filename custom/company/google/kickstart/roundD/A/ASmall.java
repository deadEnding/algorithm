package custom.company.google.kickstart.roundD.A;

import java.io.*;
import java.util.Scanner;

public class ASmall {

    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-attempt2.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for(int r = 1; r<=num; r++){
            String[] params = sc.nextLine().split(" ");
            int n = Integer.parseInt(params[0]);
            long[][] map = new long[n-1][3];
            long traval_time = Long.parseLong(params[1]);
            long lastest_time = Long.parseLong(params[2]);

            for(int k = 0; k<n-1; k++){
                String[] pk = sc.nextLine().split(" ");
                map[k][0] = Long.parseLong(pk[0]);
                map[k][1] = Long.parseLong(pk[1]);
                map[k][2] = Long.parseLong(pk[2]);
            }
            int result = count(0,0, traval_time, lastest_time, map, 0);
            if(result < 0)
                System.out.println("Case #" + r + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + r + ": "+result);
        }
    }

    private static int count(int n,long now_time, long travel_time, long arr_time, long[][] map, int s){
        if(now_time > arr_time) return -1;
        if(s>=map.length) return n;
        if(map[s][0] - now_time >= travel_time)
            return count(n+1, map[s][0]+map[s][2], travel_time, arr_time, map, s+1);
        int re1=0, re2 = 0;
        long go_time = map[s][0];
        while(go_time < now_time){
            go_time += map[s][1];
        }
        re1 = count(n, go_time+map[s][2], travel_time, arr_time, map, s+1);

        while (go_time < now_time + travel_time){
            go_time += map[s][1];
        }
        re2 = count(n+1, go_time+map[s][2], travel_time, arr_time, map, s+1);
        return Math.max(re1, re2);
    }
}
