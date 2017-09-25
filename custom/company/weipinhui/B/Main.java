package custom.company.weipinhui.B;

import java.util.*;

public class Main {

    private static HashSet<String> result = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }

        ArrayList<String> res = new ArrayList<>();
        res.addAll(result);
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
