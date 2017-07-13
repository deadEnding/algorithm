package leetcode.again.L158_ReadNCharactersGivenRead4IICallMultipleTimes;

/**
 * @author: deadend
 * @date: 4:09 PM 3/17/17
 * @version: 1.0
 * @description:
 */


class Reader4 {
    public int read4(char[] buf) {
        return 0;
    }
}


public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] tmp = new char[4];
        while (count < n) {
            int c = read4(tmp);
            for (int i = 0; i < c && count < n; i++) {
                buf[count++] = tmp[i];
            }
            if (c < 4) {
                break;
            }
        }
        return count;
    }
}
