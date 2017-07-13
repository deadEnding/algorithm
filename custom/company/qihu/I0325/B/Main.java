package custom.company.qihu.I0325.B;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class Main {

    private static int resolve(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = 0;
        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            flag = flag ^ (1 << k);
            if (map.containsKey(flag)) {
                ans += map.get(flag);
                map.put(flag, map.get(flag) + 1);
            } else {
                map.put(flag, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(resolve(s));
    }
}
