package custom.company.baidu.Q2017.Q1;

public class Main {
    public int count(int m, int n) {
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt += i == j ? 0 : (m - i) * (n - j);
            }
        }

        return cnt;
    }
}
