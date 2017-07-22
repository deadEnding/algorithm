package custom.templates;

/**
 * 步骤：
 *  1. 结果result置为单位值
 *  2. 从低位向高位遍历，位值为1时result乘上当前位位权，其中base通过平方维护每位的位权
 */

public class FastExponentiation {

    /** 矩阵快速幂 */
    public int[][] fastExpForMatrix(int[][] m, int p) {
        final int n = m.length;
        int[][] result = new int[n][n];    // 单位矩阵
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        int[][] base = m;
        while (p > 0) {
            if (p % 2 == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            p >>= 1;
        }
        return result;
    }

    /** 矩阵乘法 */
    public int[][] multiply(int[][] m1, int[][] m2) {
        final int r = m1.length, l = m1[0].length, c = m2[0].length;
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < l; k++) {
                    m[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return m;
    }

    /** 矩阵拷贝 */
    public int[][] copy(int[][] m) {
        final int n = m.length;
        int[][] mcp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mcp[i][j] = m[i][j];
            }
        }
        return mcp;
    }

    /** 整数快速幂 */
    public int fastExpForInt(int x, int p) {
        int result = 1;    // 单位1

        int base = x;
        while (p > 0) {
            if (p % 2 == 1) {
                result *= base;
            }

            base *= base;
            p >>= 1;
        }

        return result;
    }

    /** 整数快速幂取模 */
    public int fastExpAndModForInt(int x, int p, int mod) {
        int result = 1;

        int base = x % mod;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (result * base) % mod;
            }

            base = base * base % mod;
            p >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FastExponentiation().fastExpForInt(3, 4));
        System.out.println(new FastExponentiation().fastExpAndModForInt(2, 10, 3));
    }
}
