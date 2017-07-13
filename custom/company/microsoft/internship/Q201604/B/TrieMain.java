package custom.company.microsoft.internship.Q201604.B;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:34 PM 30/03/2017
 */


public class TrieMain {
    static class TrieNode {
        int status;
        int time;
        HashMap<Character, TrieNode> children;

        public TrieNode(int time) {
            this.time = time;
            children = new HashMap<>();
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode(Integer.MAX_VALUE);
        }

        public void insert(String word, int status, int time) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode(time));
                }
                p = p.children.get(c);
            }

            if (p.status == 0)
                p.status = status;

            if (word.equals("") && time < p.time) {
                p.time = time;
            }
        }

        private int searchWord(String word) {
            TrieNode p = root;
            int status = root.status;
            int minTime = root.time;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.children.containsKey(c)) {
                    break;
                }
                p = p.children.get(c);

                if (p.status != 0) {
                    if (p.time < minTime) {
                        minTime = p.time;
                        status = p.status;
                    }
                }
            }
            return status;
        }
    }

    private static String f(String p) {
        String t = Integer.toBinaryString(Integer.valueOf(p));
        while (t.length() < 8) {
            t = "0" + t;
        }
        return t;
    }

    private static String format(String rule) {
        String[] ipMask = rule.split("/", -1);
        String ip = ipMask[0];
        String[] part = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String p : part) {
            builder.append(f(p));
        }
        if (ipMask.length == 1) {
            return builder.toString();
        }
        return builder.substring(0, Integer.valueOf(ipMask[1]));
    }

    private static Trie trie = new Trie();

    private static void resolve(String[] rules) {
        for (int i = 0; i < rules.length; i++) {
            String r = rules[i];
            String[] parts = r.split(" ");
            trie.insert(format(parts[1]), parts[0].equals("allow") ? 1 : -1, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);
        String[] rules = new String[n];
        for (int i = 0; i < n; i++) {
            rules[i] = sc.nextLine();
        }

        String[] ips = new String[m];
        for (int i = 0; i < m; i++) {
            ips[i] = sc.nextLine();
        }

        resolve(rules);

        for (String ip : ips) {
            int status = trie.searchWord(format(ip));
            if (status == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
