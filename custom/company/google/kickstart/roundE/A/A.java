package custom.company.google.kickstart.roundE.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {

    static class Node {
        int step;
        String current;
        String clipboard;
        public Node(String current, String clipboard, int step) {
            this.current = current;
            this.clipboard = clipboard;
            this.step = step;
        }
    }

    private static int solve(String target) {
        if (target.equals("")) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", "", 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.current.equals(target)) {
                return node.step;
            }

            if (node.current.length() > target.length()) {
                continue;
            }

            if (!target.startsWith(node.current)) {
                continue;
            }

            // append
            for (char c ='a'; c <= 'z'; c++) {
                queue.offer(new Node(node.current + c, node.clipboard, node.step + 1));
            }

            // copy
            if (!node.current.equals("")) {
                for (int i = 0; i < node.current.length(); i++) {
                    for (int j = i + 1; j <= node.current.length(); j++) {
                        queue.offer(new Node(node.current, node.current.substring(i, j), node.step + 1));
                    }
                }
            }

            // paste
            if (!node.clipboard.equals("")) {
                queue.offer(new Node(node.current + node.clipboard, node.clipboard, node.step + 1));
            }
        }

        return -1;  // unreach
    }

    public static void main(String[] args) throws FileNotFoundException {
        String base = "/Users/deadend/Downloads/";
        String input = "A-small-attempt0";
//        String input = "A-large";
        FileInputStream fis = new FileInputStream(base + input + ".in");
        PrintStream ps = new PrintStream(new FileOutputStream(base + input + ".out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());

        for (int _c = 1; _c <= cases; _c++) {
            String s = sc.nextLine();
            System.out.println(String.format("Case #%d: %d", _c, solve(s)));
        }
    }
}
