package custom.company.huawei.A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static int compare0(String s1, String s2) {
        String[] p1 = s1.split("\\.");
        String[] p2 = s2.split("\\.");
        int i, j;
        for (i = p1.length - 1, j = p2.length - 1; i >= 0 && j >= 0; i--, j--) {
            if (!p1[i].equals(p2[j])) {
                return p1[i].compareTo(p2[j]);
            }
        }

        if (i >= 0) {
            return 1;
        } else if (j >= 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] hosts = sc.nextLine().split("\\|");
        Arrays.sort(hosts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compare0(o1, o2);
            }
        });

        for (int i = 0; i < hosts.length; i++) {
            System.out.print(hosts[i]);
            if (i != hosts.length - 1) {
                System.out.print("|");
            }
        }
    }
}
