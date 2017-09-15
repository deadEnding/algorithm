package custom.company.tencent.recurite.wxg;

public class Solution {

    public boolean isPrim(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int count(int n) {
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrim(i) && isPrim(n - i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().count(10));
    }
}
