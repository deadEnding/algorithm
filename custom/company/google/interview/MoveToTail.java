package custom.company.google.interview;

public class MoveToTail {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public void move(int[] nums, int x) {
        final int n = nums.length;
        for (int i = 0, j = n - 1; i < j;) {
            if (nums[i] == x) {
                swap(nums, i, j--);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,1,4,1};
        new MoveToTail().move(nums,1);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

    }
}
