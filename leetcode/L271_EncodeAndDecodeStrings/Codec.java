package leetcode.again.L271_EncodeAndDecodeStrings;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:03 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Codec {

    private static final char sep = '|';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer buffer = new StringBuffer();
        for (String s : strs) {
            int len = s.length();
            buffer.append(Integer.toHexString(len) + sep);
            buffer.append(s);
        }
        return buffer.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new LinkedList<>();
        for (int i = 0, start = 0; i < s.length();) {
            if (s.charAt(i) == sep) {
                int len = Integer.parseInt(s.substring(start, i), 16);
                strs.add(s.substring(i + 1, i + 1 + len));
                start = i = i + len + 1;
            } else {
                i++;
            }
        }
        return strs;
    }
}
