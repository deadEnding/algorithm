package custom.templates.finalpractice;

import java.util.LinkedList;

public class Sorting {

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = partition(nums, l, r);
            quickSort(nums, l, m - 1);
            quickSort(nums, m + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
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

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private static void merge(int[] nums, int l, int m, int r) {
        int len = r - l + 1;
        int[] tmp = new int[len];
        for (int k = 0, i = l, j = m + 1; k < len; k++) {
            long a = i <= m ? nums[i] : Integer.MAX_VALUE + 1L;
            long b = j <= r ? nums[j] : Integer.MAX_VALUE + 1L;
            tmp[k] = a <= b ? nums[i++] : nums[j++];
        }

        for (int i = l; i <= r; i++) {
            nums[i] =  tmp[i - l];
        }
    }

    public static void heapSort(int[] nums) {
        final int n = nums.length;
        buildHeap(nums);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private static void buildHeap(int[] nums) {
        final int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            adjust(nums, i, n);
        }
    }

    private static void adjust(int[] nums, int root, int end) {
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        int maxIx = root;
        if (l < end && nums[l] > nums[maxIx]) {
            maxIx = l;
        }

        if (r < end && nums[r] > nums[maxIx]) {
            maxIx = r;
        }

        if (maxIx != root) {
            swap(nums, root, maxIx);
            adjust(nums, maxIx, end);
        }
    }

    public static void radixSort(int[] nums) {
        final int R = 4;
        LinkedList<Integer>[] buckets = new LinkedList[R];

        for (int i = 0; i < R; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (long base = 1L; base < Integer.MAX_VALUE; base *= R) {
            for (int num : nums) {
                int bid = (int) (num / base % R);
                buckets[bid].offer(num);
            }

            for (int i = 0, j = 0; i < R; i++) {
                while (!buckets[i].isEmpty()) {
                    nums[j++] = buckets[i].poll();
                }
            }
        }
    }
}
