package custom.company.microsoft.internship.Q201607.C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:08 PM 31/03/2017
 */


public class Main {
    static class Member {
        int color;
        ArrayList<Integer> prevs = new ArrayList<>();
        ArrayList<Integer> nexts = new ArrayList<>();
    }

    private static boolean paintMember(int ix, Member[] members, int color) {
        for (int prev : members[ix].prevs) {
            if (members[prev].color != color) {
                return false;
            }
        }
        return true;
    }

    private static void paint(int ix, Member[] members, boolean[] unstable) {
        if (members[ix].color != 0) {
            return;
        }

        int color = ix;
        members[ix].color = ix;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(ix);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int next : members[p].nexts) {
                if (paintMember(next, members, color)) {
                    members[next].color = color;
                    queue.offer(next);
                    unstable[next] = true;
                }
            }
        }
    }

    private static int resolve(Member[] members, int n) {
        boolean[] unstable = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            paint(i, members, unstable);
        }

        int count = n;
        for (int i = 1; i <= n; i++) {
            count -= unstable[i] ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Member[] members = new Member[n + 1];

        for (int i = 0; i <= n; i++) {
            members[i] = new Member();
        }

        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                members[i].prevs.add(k);
                members[k].nexts.add(i);
            }
        }
        System.out.println(resolve(members, n));
    }
}
