package leetcode.again.L157_ReadNCharactersGivenRead4;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:34 PM 3/17/17
 * @version: 1.0
 * @description:
 */


class Reader4 {
    public int read4(char[] buf) {
        return 0;
    }
}

public class Solution extends Reader4 {

    private int bufPtr;
    private int bufCnt;
    private char[] buffer = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (bufPtr == 0) {
                bufCnt = read4(buf);
            }

            if (bufCnt == 0) {
                break;
            }

            while (ptr < n && bufPtr < bufCnt) {
                buf[ptr++] = buffer[bufPtr++];
            }
            bufPtr %= 4;
        }
        return ptr;
    }
}

class BasicSolution extends Reader4 {

    private LinkedList<Character> queue = new LinkedList<>();

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        boolean end = false;
        while (count < n && !end) {
            char[] tmpBuf = new char[4];
            if (queue.isEmpty()) {
                int c = read4(tmpBuf);
                for (int i = 0; i < c; i++) {
                    queue.offer(tmpBuf[i]);
                }
                end = c < 4;
            }

            while (!queue.isEmpty() && count < n) {
                buf[count++] = queue.poll();
            }
        }
        return count;
    }
}
