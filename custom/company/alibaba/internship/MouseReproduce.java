package custom.company.alibaba.internship;

/**
 * 老鼠繁殖
 */

public class MouseReproduce {

    static int increse(int initPair, int month) {
        int[] res = {2*initPair, 0, 0, 0, 0, 0};
        for(int i = 1; i <= month; i++){
            res[5] = res[4];
            res[4] = res[3];
            res[3] = (res[2] - 2) > 0 ? (res[2] - 2) : 0;
            res[2] = res[1];
            res[1] = res[0];
            res[0] = (res[2] + res[4]) * 2;
        }

        int result = 0;
        for(int i = 0 ; i <= 5 ; i++) {
            result += res[i];
        }
        return result;
    }

    public static void main(String[] args){
        int initPair = 1;
        int month = 8;
        for (int i = 1; i <= month; i++) {
            System.out.print(increse(initPair, i) + " ");
        }
    }
}

