package custom.company.tencent.internship.T20170402.Q4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 7:57 PM 02/04/2017
 * @desc: 字典单词的插入、查询
 */


public class Main {

    static class TrieNode {
        boolean isWord;
        int prifix = 0;
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            p.prifix++;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode());
                }
                p = p.children.get(c);
                p.prifix++;
            }
            p.isWord = true;
        }

        private TrieNode searchWord(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.children.containsKey(c)) {
                    return null;
                }
                p = p.children.get(c);
            }
            return p;
        }

        public boolean search(String word) {
            TrieNode p = searchWord(word);
            return p != null && p.isWord;
        }

        public int startsWith(String prefix) {
            TrieNode node = searchWord(prefix);
            return node == null ? 0 : node.prifix;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(sc.nextLine());
        }

        int m = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] p = sc.nextLine().split(" ", -1);
            if (p[0].equals("insert")) {
                if (trie.search(p[1])) {
                    System.out.println(1);
                } else {
                    trie.insert(p[1]);
                    System.out.println(0);
                }
            } else {
                System.out.println(trie.startsWith(p[1]));
            }
        }
    }
}
