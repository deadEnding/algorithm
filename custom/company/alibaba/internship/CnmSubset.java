package custom.company.alibaba.internship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 下午7:19 2017/3/27
 */


public class CnmSubset {

    private void dfs(int i, int m, int j, int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {
        if (i == m) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (j == nums.length) {
            return;
        }

        path.add(nums[j]);
        dfs(i + 1, m, j + 1, nums, path, result);
        path.remove(path.size() - 1);

        dfs(i, m, j + 1, nums, path, result);
    }

    public List<List<Integer>> subset(int[] nums, int m) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, m, 0, nums, new ArrayList<>(m), result);
        return result;
    }
}

class IterCnmSubset {
    private void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public void subset(int n, int m) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i;
        }

        print(arr);
        for (int i = m - 1; i >= 0;) {
            if (arr[i] + m - i >= n) {
                i--;
                continue;
            }

            arr[i]++;
            for (int k = i + 1; k < m; k++) {
                arr[k] = arr[k - 1] + 1;
            }

            print(arr);
            for (int j = m - 1; j >= i + 1;) {
                if (arr[j] + m - j >= n) {
                    j--;
                    continue;
                }

                arr[j]++;
                for (int k = j + 1; k < m; k++) {
                    arr[k] = arr[k - 1] + 1;
                }
                print(arr);
                j = m - 1;
            }
        }
    }

    public static void main(String[] args) {
        new IterCnmSubset().subset(15, 9);
    }
}


