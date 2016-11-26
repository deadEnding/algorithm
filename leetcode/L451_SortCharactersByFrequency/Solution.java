package leetcode.L451_SortCharactersByFrequency;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 12:26 PM 11/26/16
 * @version: 1.0
 * @description:
 */

class Char implements Comparable<Char> {
    char c;
    int count;

    public Char(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public int compareTo(Char o) {
        return o.count - this.count;
    }
}


public class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        PriorityQueue<Char> queue = new PriorityQueue<>();
        for (char c : map.keySet()) {
            queue.offer(new Char(c, map.get(c)));
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            Char ch = queue.poll();
            for (int i = 0; i < ch.count; i++) {
                sb.append(ch.c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new Solution().frequencySort(s));
    }
}