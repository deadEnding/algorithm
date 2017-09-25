package custom.company.hulu.others.phone;

public class Main {

    private static boolean isValid(int m, int[] nums, int l, int len) {
        return false;
    }

    public static int solve(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int l = sum / k;
        int r = 100 * 100 / k + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isValid(m, nums, l, nums.length - k + 1)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,9,2};
        System.out.println(solve(nums, 3));
    }
}
