package custom.company.alibaba.internship;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:41 PM 3/11/17
 * @version: 1.0
 * @description:  给定若干不同整数，求总和为sum的所有组合数（每个整数可使用任意多次）
 */


public class ValuePatition {

    private int[] vals = {11, 9, 5, 4, 3, 2, 1};

    private int resolve(int n, int mIndex, HashMap<Integer, HashMap<Integer, Integer>> cache) {
        if (mIndex >= vals.length) {
            return 0;
        }

        if (!cache.containsKey(n)) {
            cache.put(n, new HashMap<>());
        }

        HashMap<Integer, Integer> map = cache.get(n);
        if (!map.containsKey(mIndex)) {
            int count;
            if (n < vals[mIndex]) {
                count = resolve(n, mIndex + 1, cache);
            } else if (n == vals[mIndex]) {
                count = resolve(n, mIndex + 1, cache) + 1;
            } else {
                count = resolve(n, mIndex + 1, cache) + resolve(n - vals[mIndex], mIndex, cache);
            }
            map.put(mIndex, count);
        }
        return map.get(mIndex);
    }

    public int resolve(int n) {
        return resolve(n, 0, new HashMap<>());
    }

    public static void main(String[] args) {
        System.out.println(new ValuePatition().resolve(4));
    }
}
