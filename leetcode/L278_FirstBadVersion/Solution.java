package leetcode.L278_FirstBadVersion;

/**
 * @author: deadend
 * @date: 7:01 PM 12/11/16
 * @version: 1.0
 * @description:
 */

class VersionControl {
    public boolean isBadVersion(int version) {
        return true;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
