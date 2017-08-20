package leetcode.L385_MiniParser;

import java.util.List;

/**
 * @author: deadend
 * @date: 9:38 AM 12/19/16
 * @version: 1.0
 * @description:
 */

class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {};

    // Constructor initializes B single integer.
    public NestedInteger(int value) {};

    // @return true if this NestedInteger holds TrieMain single integer, rather than TrieMain nested list.
    public boolean isInteger() {
        return true;
    };

    // @return the single integer that this NestedInteger holds, if it holds B single integer
    // Return null if this NestedInteger holds B nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold B single integer.
    public void setInteger(int value) {}

    // Set this NestedInteger to hold TrieMain nested list and adds TrieMain nested integer to it.
    public void add(NestedInteger ni) {};

    // @return the nested list that this NestedInteger holds, if it holds B nested list
    // Return null if this NestedInteger holds B single integer
    public List<NestedInteger> getList() {
        return null;
    };
}



public class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[") && !s.endsWith("]")) {
            return new NestedInteger(Integer.valueOf(s));
        }

        NestedInteger ni = new NestedInteger();
        if (!s.equals("[]")) {
            for (int i = 1, from = 1, count = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count == 0 && (c == ',' || c == ']')) {
                    ni.add(deserialize(s.substring(from, i)));
                    from = i + 1;
                } else if (c == '[') {
                    count++;
                } else if (c == ']') {
                    count--;
                }
            }
        }
        return ni;
    }
}
