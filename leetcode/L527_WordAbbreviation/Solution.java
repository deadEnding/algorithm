package leetcode.L527_WordAbbreviation;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:43 PM 01/04/2017
 */


public class Solution {

    class Node {
        int count;
        HashMap<Character, Node> children = new HashMap<>();
        public Node() {
            count = 1;
        }
    }

    class Trie {
        Node root = new Node();

        public void insert(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.children.containsKey(c)) {
                    Node next = new Node();
                    p.children.put(c, next);
                    p = next;
                } else {
                    p = p.children.get(c);
                    p.count++;
                }
            }
        }

        public int searchMinPrefix(String word) {
            Node p = root;
            int prefix = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                p = p.children.get(c);
                prefix++;
                if (p.count == 1) {
                    break;
                }
            }
            return prefix;
        }
    }

    private String abbr(String s, int preLen) {
        if (s.length() <= 3 || preLen >= s.length() - 2) {
            return s;
        }

        return s.substring(0, preLen) + (s.length() - preLen - 1) + s.charAt(s.length() - 1);
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, ArrayList<Integer>> abmap = new HashMap<>();
        List<String> abbrs = new ArrayList<>();
        for (int i = 0; i < dict.size(); i++) {
            String s = dict.get(i);
            String ab = abbr(s, 1);
            abbrs.add(ab);
            if (abmap.containsKey(ab)) {
                abmap.get(ab).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                abmap.put(ab, list);
            }
        }

        for (String ab : abmap.keySet()) {
            ArrayList<Integer> list = abmap.get(ab);
            if (list.size() == 1) {
                abbrs.set(list.get(0), ab);
            } else {
                Trie trie = new Trie();
                for (int i : list) {
                    trie.insert(dict.get(i));
                }

                for (int i : list) {
                    int prefix = trie.searchMinPrefix(dict.get(i));
                    abbrs.set(i, abbr(dict.get(i), prefix));
                }
            }
        }

        return abbrs;
    }

    public static void main(String[] args) {
        String[] d = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        List<String> dict = new LinkedList<>();
        for (String i : d) {
            dict.add(i);
        }
        System.out.println(new Solution().wordsAbbreviation(dict));
    }
}
