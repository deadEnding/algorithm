package custom.company.google.interview;

import java.util.LinkedList;
import java.util.Queue;


/**
 * http://www.1point3acres.com/bbs/thread-220259-1-1.html
 */
public class CarAccelerateOrReverse {

    public static int finalPosition(String cmds) {
        int position = 0;
        for (int i = 0, direct = 1, speed = 1; i < cmds.length(); i++) {
            char c = cmds.charAt(i);
            if (c == 'A') {
                speed *= 2;
            } else {
                speed = 1;
                direct *= -1;
            }

            position += speed * direct;
        }

        return position;
    }

    static class State {
        int position;
        int speed;
        int direct;
        String cmds;

        public State(int position, int speed, int direct, String cmds) {
            this.position = position;
            this.speed = speed;
            this.direct = direct;
            this.cmds = cmds;
        }
    }

    public static String shortestCmds(int position) {
        State state = new State(0, 1, 1, "");
        Queue<State> queue = new LinkedList<>();
        queue.offer(state);

        State s = null;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (s.position == position) {
                break;
            }

            queue.offer(new State(s.position + s.speed * 2 * s.direct, s.speed * 2, s.direct, s.cmds + "A"));
            queue.offer(new State(s.position + 1 * s.direct * -1, 1, s.direct * -1, s.cmds + "R"));
        }

        return s.cmds;
    }

    public static void main(String[] args) {
//        String cmds = "AARA";
//        System.out.println(finalPosition(cmds));
        System.out.println(shortestCmds(5));
    }
}
