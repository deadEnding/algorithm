package custom.CC150.CH11;

import java.util.Iterator;

/**
 * @author: deadend
 * @date: 2:51 PM 1/3/17
 * @version: 1.0
 * @description:
 */

public class CircularArray<T> implements Iterable<T> {

    /* 旋转数组 */
    private T[] items;
    /* 旋转数组实际起始索引 */
    private int head = 0;

    /**
     * 初始化
     * @param size 数组大小
     */
    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    /**
     * 索引映射
     * @param index 原索引
     * @return 实际索引
     */
    private int map(int index) {
        while (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    /**
     * 旋转操作
     * @param shiftToRight 向右旋转次数，负数表示向左旋转
     */
    public void rotate(int shiftToRight) {
        head = map(items.length - shiftToRight);
        System.out.println("head: " + head);
    }

    /**
     * 根据索引获取数组元素
     * @param i 索引
     * @return 数组元素
     */
    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new java.lang.IndexOutOfBoundsException(String.valueOf(i));
        }
        return items[map(i)];
    }

    /**
     * 数组元素赋值
     * @param i 索引
     * @param item 新元素
     */
    public void set(int i, T item) {
        items[map(i)] = item;
    }

    /**
     * 实现Iterable<T>接口的iterator方法
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>(this);
    }

    /**
     * 迭代器类
     * @param <TI> 数组元素类型
     */
    private class CircularArrayIterator<TI> implements Iterator<TI> {

        /* 当前迭代位置 */
        private int _curr;
        /* 待遍历元素 */
        private TI[] items;

        public CircularArrayIterator(CircularArray<TI> array) {
            items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _curr < items.length;
        }

        @Override
        public TI next() {
            return items[map(_curr++)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
