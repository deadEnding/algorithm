package leetcode.again.L556_NextGreaterElementIII;


public class Solution {
    public void swap(char[] chs, int i, int j) {
        char c = chs[i];
        chs[i] = chs[j];
        chs[j] = c;
    }

    public void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i++ , j--);
        }
    }

    public int binarySearch(char[] chs, int s, int e, char t) {
        while (s < e) {
            int m = s + (e - s) / 2;
            if (chs[m] <= t) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();

        int i = chs.length - 1;
        while (i >= 1) {
            if (chs[i - 1] < chs[i]) {
                break;
            }
            i--;
        }

        if (i < 1) {
            return -1;
        }

        reverse(chs, i , chs.length - 1);
        int j = binarySearch(chs, i, chs.length - 1, chs[i - 1]);
        swap(chs, i - 1, j);
        long l = Long.valueOf(String.valueOf(chs));
        return l > Integer.MAX_VALUE ? -1 : (int) l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(21));
    }
}
