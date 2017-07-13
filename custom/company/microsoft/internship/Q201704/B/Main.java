package custom.company.microsoft.internship.Q201704.B;

import java.util.Scanner;

public class Main {

    public static int hours(long N, int Q){
        int max = (int)Math.ceil(Math.log(N) / Math.log(2));
        int l = 0, r = max;// l,r times build robots then build product

        while(l < r){

            int mid = l + (r - l)/2;

            long ansr = Integer.MAX_VALUE, ansl = Integer.MAX_VALUE, ans;

            if(mid - 1 >= 0)
                ansl = doget(N, Q, mid - 1);

            ans  = doget(N, Q, mid);

            if(mid + 1 <= max)
                ansr = doget(N, Q, mid + 1);

            if(ans < ansr && ans < ansl)
                return (int)ans;

            if(ans < ansl && ans > ansr){
                l = mid + 1;
            }else if(ans > ansl && ans < ansr){
                r = mid - 1;
            }else{
                l++;
            }

        }
        return (int)doget(N, Q, l);
    }

    private static long doget(long N, int Q, int m){
        long machine = (long)Math.pow(2, m);
        long res =  m * Q;

        res += (int)Math.ceil(N * 1.0 / machine);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long N = in.nextLong();
            int Q = in.nextInt();
            System.out.println(hours(N, Q));
        }
        in.close();
    }
}
