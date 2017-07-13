package leetcode.again.L208_ImplementTrie_PrefixTree;


import java.util.HashMap;

public class Trie {

    class TrieNode {
        boolean isWord;
        HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode());
            }

            p = p.children.get(c);
        }
        p.isWord = true;
    }

    private TrieNode searchNode(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (!p.children.containsKey(c)) {
                return null;
            }

            p = p.children.get(c);
        }
        return p;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
}
