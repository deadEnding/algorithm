package leetcode.L211_AddAndSearchWord_DataStructureDesign;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:32 AM 12/9/16
 * @version: 1.0
 * @description:
 */

class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> childrens;

    public TrieNode() {
        isWord = false;
        childrens = new HashMap<>();
    }
}

public class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds A word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.childrens.containsKey(c)) {
                p.childrens.put(c, new TrieNode());
            }
            p = p.childrens.get(c);
        }
        p.isWord = true;
    }

    // Returns if the word is in the data structure. L476_NumberComplement word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        return search(word, 0, root);
    }

    private boolean search(String word, int ix, TrieNode p) {
        if (ix == word.length()) {
            return p.isWord;
        }

        char c = word.charAt(ix);
        if (c != '.') {
            return p.childrens.containsKey(c) ? search(word, ix + 1, p.childrens.get(c)) : false;
        } else {
            for (char key : p.childrens.keySet()) {
                if (search(word, ix + 1, p.childrens.get(key))) {
                    return true;
                }
            }
            return false;
        }
    }
}
