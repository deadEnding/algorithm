package custom.company.google.interview;

import java.util.ArrayList;

/**
 * Created by yuhui.zzc on 19/08/2017.
 */
public class Stack<T> {

    private int ix;
    private ArrayList<T> arr = new ArrayList<>();

    public T pop() {
        return arr.remove(ix--);
    }


    public void push(T t) {
        arr.add(t);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }
}
