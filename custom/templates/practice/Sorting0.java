package custom.templates.practice;

public class Sorting0 {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    /**
     * 快排: partitions -> sort
     */
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];

            while (l < r && nums[l] < pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = partition(nums, l, r);
            quickSort(nums, l, m);
            quickSort(nums, m + 1, r);
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }


    /**
     * 堆排序: 建堆(调整 n/2 -> 0) -> 排序(n-1 -> 0 交换、调整)
     */
    private void adjust(int[] nums, int ix, int end) {
        int max = ix;
        int l = 2 * ix + 1;
        int r = 2 * ix + 2;

        if (l < end && nums[l] > nums[max]) {
            max = l;
        }

        if (r < end && nums[r] > nums[max]) {
            max = r;
        }

        if (ix != max) {
            swap(nums, max, ix);
            adjust(nums, max, end);
        }
    }

    private void buildHeap(int[] nums) {
        final int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
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
        int[] nums = {3,5,2,7,6,1,4};
        new Sorting0().quickSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
