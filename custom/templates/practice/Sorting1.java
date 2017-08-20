package custom.templates.practice;

/**
 * Created by yuhui.zzc on 13/08/2017.
 */
public class Sorting1 {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

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


    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        final int N = r - l + 1;
        int[] tmp = new int[N];
        for (int ix = 0, i = l, j = m + 1; ix < N; ix++) {
            long a = i <= m ? nums[i] : Integer.MAX_VALUE + 1L;
            long b = j <= r ? nums[j] : Integer.MAX_VALUE + 1L;
            tmp[ix] = a < b ? nums[i++] : nums[j++];
        }

        for (int i = l; i <= r; i++) {
            nums[i] = tmp[i - l];
        }
    }

    private void adjust(int[] nums, int ix, int end) {
        int max = ix;
        int l = 2 * ix + 1;
        if (l < end && nums[l] > nums[max]) {
            max = l;
        }

        int r = 2 * ix + 2;
        if (r < end && nums[r] > nums[max]) {
            max = r;
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

    public void bubbleSort(int[] nums) {
        final int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,5,2,7,6,1,6,4};
//        new Sorting1().heapSort(nums);
//        new Sorting1().quickSort(nums);
//        new Sorting1().mergeSort(nums);
        new Sorting1().bubbleSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
