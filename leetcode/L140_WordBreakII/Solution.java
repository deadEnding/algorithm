package leetcode.L140_WordBreakII;

import java.util.*;

/**
 * @author: deadend
 * @date: 4:28 PM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        final int n = s.length();
        List<String>[] sentences = new List[n + 1];
        sentences[n] = new ArrayList<>();
        sentences[n].add("");

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                String segment = s.substring(i, j);
                if (wordDict.contains(segment) && sentences[j] != null) {
                    if (sentences[i] == null) {
                        sentences[i] = new ArrayList<>();
                    }
                    for (String t : sentences[j]) {
                        if (t.equals("")) {
                            sentences[i].add(segment);
                        } else {
                            sentences[i].add(segment + " " + t);
                        }
                    }
                }
            }
        }

        return sentences[0];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] parts = {"A","aa","alibaba","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> set = new HashSet<>();
        for (String t : parts) {
            set.add(t);
        }
        System.out.println(new RightSolution().wordBreak(s, set).size());
    }
}

class RightSolution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The RandomOneHundred object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
