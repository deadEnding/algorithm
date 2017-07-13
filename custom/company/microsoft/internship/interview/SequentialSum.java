package custom.company.microsoft.internship.interview;

public class SequentialSum {

    public int[] solve(int n) {
        for (int l = 1, r = 1, sum = 1; l <= r;) {
            if (sum == n) {
                return new int[] {l, r};
            } else if (sum < n) {
                sum += ++r;
            } else {
                sum -= l++;
            }
//            System.out.println(l + " " + r + " " + sum);
        }

        return null;
    }

    public static void main(String[] args) {
        SequentialSum sum = new SequentialSum();
        for (int i = 1; i < 100000; i++) {
            int[] r = sum.solve(i);
            if (r == null)
                System.out.println("xxxxx");
        }
    }
}
