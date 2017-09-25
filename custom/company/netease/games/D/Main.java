package custom.company.netease.games.D;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int hp, atk, cd;
    private static int[] skills = new int[3];
    private static int[] enhp = new int[3];
    private static int[] enatk = new int[3];

    private static int killTimes(int ehp) {
        PriorityQueue<int[]> skillStart = new PriorityQueue<>(3,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[2] - o1[2];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < 3; i++) {
            if (skills[i] > atk) {
                skillStart.offer(new int[] {i, 0, enatk[i]});
            }
        }

        if (skillStart.isEmpty()) {
            return (int) (Math.ceil((double) ehp / atk));
        }

        int current = 0;
        while (ehp > 0) {
            int[] start = skillStart.poll();
            int delta = start[1] - current;
            if (delta * atk >= ehp) {
                return current + (int) (Math.ceil((double) ehp / atk));
            }

            ehp -= delta * atk;
            current += delta;

            ehp -= skills[start[0]];
            start[1] += cd;
            current++;
            skillStart.offer(start);
        }

        return current;
    }

    private static int[] getAllTimes() {
        int[] times = new int[3];
        for (int i = 0; i < 3; i++) {
            times[i] = killTimes(enhp[i]);
        }
        return times;
    }

    private static int solve() {
        int[] times = getAllTimes();

        int max = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && j != k && i != k) {
                        int remain = hp - enatk[i] * times[i] - enatk[j] * (times[i] + times[j])
                                - enatk[k] * (times[i] + times[j] + times[k]);
                        if (remain > 0) {
                            max = Math.max(max, remain);
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cs = sc.nextInt();
        for (int _c = 0; _c < cs; _c++) {
            hp = sc.nextInt();
            atk = sc.nextInt();
            cd = sc.nextInt();

            for (int i = 0; i < 3; i++) {
                skills[i] = sc.nextInt();
            }

            for (int i = 0; i < 3; i++) {
                enhp[i] = sc.nextInt();
                enatk[i] = sc.nextInt();
            }

            System.out.println(solve());
        }
    }
}
