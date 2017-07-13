package custom.CC150.CH11;

/**
 * @author: deadend
 * @date: 4:44 PM 1/2/17
 * @version: 1.0
 * @description:
 */


public class MergeAB {

    public void merge(int[] A, int m, int[] B, int n) {
        for (int ix = m + n - 1, i = m - 1, j = n - 1; ix >= 0; ix--) {
            long a = i >= 0 ? A[i] : Integer.MIN_VALUE - 1L;
            long b = j >= 0 ? B[j] : Integer.MIN_VALUE - 1L;
            if (b < Integer.MIN_VALUE) {    // A中的元素已经排列好
                return;
            }
            A[ix] = a >= b ? A[i--] : B[j--];
        }
    }
}
