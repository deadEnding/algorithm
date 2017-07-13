package custom.company.baidu;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private int n, m;

    public Game(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        while (n > 0) {
            System.out.print("输入拿走的棋子个数: ");
            int ix = sc.nextInt();
            if (!(1 <= ix && ix <= m) || ix > n) {
                System.out.println("输入有误，重新输入");
                continue;
            }

            n -= ix;

            if (n == 0) {
                System.out.println("玩家胜利");
                return;
            }

            int jx;
            if (n % (1 + m) == 0) {
                jx = random.nextInt(m) + 1;
            } else {
                jx = n % (1 + m);
            }
            System.out.println("电脑拿走的棋子个数: " + jx);
            n -= jx;

            if (n == 0) {
                System.out.println("电脑胜利");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(8, 3);
        game.start();
    }
}
