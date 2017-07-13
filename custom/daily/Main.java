package custom.daily;

/**
 * @author: deadend
 * @date: 8:38 PM 03/04/2017
 */


import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        int len = str.length();
        int N = len/16;
        for(int i =0;i<N;i++){
            System.out.println(transform(str.substring(i*16, (i+1)*16) , i));
        }
    }

    private static String transform(String s, int i){
        StringBuilder sbBuilder = new StringBuilder();
        String index = Integer.toHexString(i*16).toString();
        int len = index.length();
        for(int j =0;j<8-len;j++){
            index = "0" +index;
        }
        sbBuilder.append(index);
        sbBuilder.append("  ");
        for(int j=0;j<16;j++){
            sbBuilder.append(Integer.toHexString(s.charAt(j)).toString());
            sbBuilder.append(" ");
            if(j==8){
                sbBuilder.append(" ");
            }
        }
        sbBuilder.append(" ");
        sbBuilder.append(s);
        return sbBuilder.toString();
    }

}
