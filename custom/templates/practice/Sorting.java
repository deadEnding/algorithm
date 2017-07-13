package custom.templates.practice;

/**
 * @author: yuhui
 * @date: 16/06/2017
 */


public class Sorting {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int s, int e) {
        if (s < e) {
            int m = partition(nums, s, e);
            quickSort(nums, s, m);
            quickSort(nums, m + 1, e);
        }
    }

    private int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] >= pivot) {
                e--;
            }
            swap(nums, s, e);

            while (s < e && nums[s] < pivot) {
                s++;
            }
            swap(nums, s, e);
        }
        nums[s] = pivot;
        return s;
    }


    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int s, int e) {
        if (s < e) {
            int m = s + (e - s) / 2;
            mergeSort(nums, s, m);
            mergeSort(nums, m + 1, e);
            merge(nums, s, m, e);
        }
    }

    private void merge(int[] nums, int s, int m, int e) {
        int len = e - s + 1;
        int[] tmp = new int[len];
        for (int i = s, j = m + 1, k = 0; i <= m || j <= e;) {
            long a = i <= m ? nums[i] : Integer.MAX_VALUE + 1L;
            long b = j <= e ? nums[j] : Integer.MAX_VALUE + 1L;
            tmp[k++] = a < b ? nums[i++] : nums[j++];
        }

        for (int ix = s, k = 0; k < len; k++) {
            nums[ix++] = tmp[k];
        }
    }


    public void heapSort(int[] nums) {
        final int n = nums.length;
        buildHeap(nums);
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private void buildHeap(int[] nums) {
        final int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            adjust(nums, i, n);
        }
    }

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

        if (max != ix) {
            swap(nums, max, ix);
            adjust(nums, max, end);
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
