package custom.templates;

import java.util.HashMap;

class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode());
            }
            p = p.children.get(c);
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

    public boolean startsWith(String prefix) {
        return searchWord(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deadend");
        System.out.println(trie.search("deadend"));
        System.out.println(trie.startsWith("dead"));
    }
}
