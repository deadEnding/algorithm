package custom.templates.practice;

public class HeapSort {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void adjust(int[] nums, int ix, int end) {
        int lc = 2 * ix + 1;
        int rc = 2 * ix + 2;
        int max = ix;

        if (lc < end && nums[lc] > nums[max]) {
            max = lc;
        }

        if (rc < end && nums[rc] > nums[max]) {
            max = rc;
        }

        if (max != ix) {
            swap(nums, max, ix);
            adjust(nums, max, end);
        }
    }

    private void buildHeap(int[] nums) {
        final int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            adjust(nums, i, n);
        }
    }

    public void heapSort(int[] nums) {
        final int n = nums.length;
        buildHeap(nums);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,5,2,7,6,1,6,4};
        new Sorting().heapSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
