package custom.company.xiaomi.B;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static class TrieNode {
        int tag = 0;
        HashMap<String, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] word, int tag) {
            TrieNode p = root;
            for (int i = 0; i < word.length; i++) {
                String c = word[i];
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode());
                }
                p = p.children.get(c);
            }
            p.tag = tag;
        }

        private int searchWord(String[] word) {
            TrieNode p = root;
            int t = 0;
            for (int i = 0; i < word.length; i++) {
                String c = word[i];
                if (!p.children.containsKey(c)) {
                    return t;
                }
                p = p.children.get(c);
                if (p.tag != 0) {
                    t = p.tag;
                }
            }
            return t;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean top = true;
        Trie trie = new Trie();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("-")) {
                top = false;
                continue;
            }

            if (top) {
                String[] two = s.split(" ");
                String[] w = two[0].substring(1).split("/");
                int tag = Integer.valueOf(two[1]);
                trie.insert(w, tag);
            } else {
                String[] w = s.substring(1).split("/");
                System.out.println(trie.searchWord(w));
            }
        }
    }
}

