package custom.company.yixin.A;

import java.util.Scanner;

public class Main {

    public static int kmp(String s, String t) {
        int[] next = getNextArray(t);
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for(int i = 0, j = 0; i < ch1.length;) {
            if(ch1[i] == ch2[j]) {
                if(j == ch2.length-1) {
                    return i - ch2.length + 1;
                }
                i++;
                j++;
            } else if(j==0) {
                i++;
            } else {
                j = next[j-1]+1;
            }
        }
        return -1;
    }

    public static int[] getNextArray(String t) {
        int[] a = new int[t.length()];
        char[] c = t.toCharArray();
        a[0] = -1;
        for(int i = 0, j = 1; j < t.length(); j++) {
            i = a[j - 1];
            while(i >= 0 && c[j] != c[i+1]) {
                i = a[i];
            }
            if(c[j] == c[i+1]) {
                a[j] = i+1;
            } else {
                a[j] = -1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        System.out.println(kmp(st[0], st[1]));
    }
}
