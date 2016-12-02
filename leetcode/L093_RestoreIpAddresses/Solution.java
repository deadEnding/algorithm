package leetcode.L093_RestoreIpAddresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:01 PM 12/2/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<String> result = new LinkedList<>();

    private void restrore(int ix, String s, ArrayList<String> path) {
        final int n = s.length();
        if (ix == n) {
            if (path.size() == 4) {
                StringBuffer sb = new StringBuffer();
                for (String slug : path) {
                    sb.append(slug);
                    sb.append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
            }
            return;
        }

        if (path.size() == 4) {
            return;
        }

        for (int i = ix+ 1; i <= Math.min(n, ix + 3); i++) {
            int v = Integer.valueOf(s.substring(ix, i));
            if (0 <= v && v <= 255) {
                path.add(String.valueOf(v));
                restrore(i, s, path);
                path.remove(path.size() - 1);
            }

            if (s.charAt(ix) == '0') {
                break;
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        restrore(0, s, new ArrayList<String>(4));
        return result;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = new Solution().restoreIpAddresses(s);
        for (String ip : result) {
            System.out.println(ip);
        }
    }
}
