package custom.codinginterviews.CH5;

/**
 * @author: deadend
 * @date: 11:21 AM 2/7/17
 * @version: 1.0
 * @description:
 */


public class ReverseWords {

    public String reverse(String s) {
        StringBuffer buffer = new StringBuffer();
        int start = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                if (start < i) {
                    buffer.insert(0, s.substring(start, i) + (buffer.length() == 0 ? "" : " "));
                }
                while (s.charAt(i) == ' ') {
                    i++;
                }
                start = i;
            } else {
                i++;
            }
        }
        if (start < s.length()) {
            buffer.insert(0, s.substring(start) + (buffer.length() == 0 ? "" : " "));
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "I am A   student.";
        System.out.println(new ReverseWords().reverse(s));
    }
}
