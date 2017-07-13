package custom.company.microsoft.internship.interview;

public class RangeMinQuery {

    private int[][] mins;

    public RangeMinQuery(int[] nums) {
        final int n = nums.length;
        final int l = max(n);
        mins = new int[n][l + 1];

        for (int i = n - 1; i > 0; i--) {
            mins[i][1] = nums[i];
            for (int j = 2; i + j - 1 < n; j <<= 1) {
                mins[i][j] = Math.min(nums[i], mins[i + 1][j - 1]);
            }
        }
    }

    private int max(int n) {
        int x = 1;
        while ((x << 1) <= n) {
            x <<= 1;
        }
        return x;
    }

    public int query(int s, int e) {
        int l = e - s + 1;
        int min = Integer.MAX_VALUE;
        for (int i = 31; i >= 0; i--) {
            if ((l & (1 << i)) != 0) {
                min = Math.min(min, mins[s][1 << i]);
                s += 1 << i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        RangeMinQuery rmq = new RangeMinQuery(nums);
        System.out.println(rmq.query(5, 5));
    }
}
