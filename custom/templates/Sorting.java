package custom.templates;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:34 AM 12/26/16
 * @version: 1.0
 * @description:
 */


public class Sorting {

    // 直接插入排序
    public static void insertionSort(int[] nums) {
        final int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j - 1 >= 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }


    // 冒泡排序
    public static void bubbleSort(int[] nums) {
        final int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }


    // 简单选择排序
    public static void selectionSort(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(nums, i, min);
            }
        }
    }


    // 快速排序
    private static int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            nums[i] = nums[j];

            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    private static void quickSort(int[] nums, int i, int j) {
        if (i < j) {
            int ix = partition(nums, i, j);
            quickSort(nums, i, ix - 1);
            quickSort(nums, ix + 1, j);
        }
    }

    public static void quickSort(int[] nums) {
        final int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    // 归并排序
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];

        int i = low, j = mid + 1;
        for (int k = 0; k < tmp.length; k++) {
            long n1 = i <= mid ? nums[i] : Integer.MAX_VALUE + 1L;
            long n2 = j <= high ? nums[j] : Integer.MAX_VALUE + 1L;
            tmp[k] = n1 <= n2 ? nums[i++] : nums[j++];
        }

        for (int t : tmp) {
            nums[low++] = t;
        }
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void mergeSort(int[] nums) {
        final int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }

    // 堆排序
    private static void adjust(int[] nums, int i, int end) {
        int lc = (i + 1) * 2 - 1;
        int rc = (i + 1) * 2;
        int max = i;

        if (lc <= end && nums[lc] > nums[max]) {
            max = lc;
        }

        if (rc <= end && nums[rc] > nums[max]) {
            max = rc;
        }

        if (max != i) {
            swap(nums, max, i);
            adjust(nums, max, end);
        }
    }

    // 建堆时间复杂度是 O(n)
    private static void buildHeap(int[] nums) {
        final int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(nums, i, n - 1);
        }
    }

    public static void heapSort(int[] nums) {
        final int n = nums.length;
        buildHeap(nums);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i - 1);
        }
    }


    // 基数排序（下面针对非负数组，对于含负数的数组，可将全部元素加定值变为整数，排序后再恢复）
    public static void radixSort(int[] nums) {
        final int R = 4;
        LinkedList<Integer>[] buckets = new LinkedList[R];

        for (int i = 0; i < R; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (long base = 1L; base < Integer.MAX_VALUE; base *= R) {
            for (int num : nums) {
                buckets[(int) (num / base % R)].offer(num);
            }

            for (int i = 0, j = 0; i < R; i++) {
                while (!buckets[i].isEmpty()) {
                    nums[j++] = buckets[i].poll();
                }
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,5,3,5,4,3};
        int[] nums = {3,5,2,7,6,1,4};
//        insertionSort(nums);
//        bubbleSort(nums);
//        selectionSort(nums);
//        quickSort(nums);
//        mergeSort(nums);
//        radixSort(nums);
        heapSort(nums);
        print(nums);
    }
}
