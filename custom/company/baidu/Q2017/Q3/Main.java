package custom.company.baidu.Q2017.Q3;

public class Main {

    private static char[] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public String transform(int x, int n) {
        if (x == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        while (x != 0) {
            builder.insert(0, map[x % n]);
            x /= n;
        }
        return builder.toString();
    }
}
