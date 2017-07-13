package custom.company.netease.intern.Q0326;

import java.util.Scanner;

public class MagicBracelet {

    /** 矩阵快速幂 */
    public static int[][] fastExpForMatrix(int[][] m, int p) {
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
    public static int[][] multiply(int[][] m1, int[][] m2) {
        final int r = m1.length, l = m1[0].length, c = m2[0].length;
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < l; k++) {
                    m[i][j] += m1[i][k] * m2[k][j] % 100;
                }
            }
        }
        return m;
    }

    public static int[] resolve(int[] nums, int k) {
        final int n = nums.length;
        int[][] matrix = new int[n][n];
        for (int j = 0; j < n; j++) {
            matrix[j][j] = matrix[(j + 1) % n][j] = 1;
        }

        int[][] km = fastExpForMatrix(matrix, k);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += nums[j] * km[j][i];
                result[i] %= 100;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = resolve(nums, k);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}
