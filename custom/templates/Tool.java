package custom.templates;

/**
 * @author: deadend
 * @date: 2:39 PM 3/13/17
 * @version: 1.0
 * @description:  http://blog.csdn.net/xiaofengcanyuexj/article/details/20154401
 */


public class Tool {

    /** 最大公约数 */
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    /** 最小公倍数 */
    public int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    public static void main(String[] args) {
        Tool t = new Tool();
    }
}
