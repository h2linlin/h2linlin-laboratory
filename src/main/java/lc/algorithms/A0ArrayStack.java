package lc.algorithms;

import java.util.Iterator;

/**
 * @Desc 用数组的方式实现栈
 * @Author zh wu
 * @Date 2019/8/15
 */
public class A0ArrayStack<Item> implements A0Stack<Item> {
    private Item[] itemArray = (Item[])new Object[1];   // 栈容器数组
    private int itemCount = 0;  // 栈内当前元素数量

    @Override
    public A0Stack push(Item item) {
        return null;
    }

    @Override
    public Item pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    // 栈已满
    public boolean isFull() {
        return itemCount == itemArray.length;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {

    }
}

/*public class ArrayStack<Item> implements MyStack<Item> {

    // 栈元素数组，只能通过转型来创建泛型数组
    private Item[] a = (Item[]) new Object[1];

    // 元素数量
    private int N = 0;


    @Override
    public MyStack<Item> push(Item item) {
        check();
        a[N++] = item;
        return this;
    }


    @Override
    public Item pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        Item item = a[--N];

        check();

        // 避免对象游离
        a[N] = null;

        return item;
    }


    private void check() {

        if (N >= a.length) {
            resize(2 * a.length);

        } else if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
    }


    *//**
     * 调整数组大小，使得栈具有伸缩性
     *//*
    private void resize(int size) {

        Item[] tmp = (Item[]) new Object[size];

        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }

        a = tmp;
    }


    @Override
    public boolean isEmpty() {
        return N == 0;
    }


    @Override
    public int size() {
        return N;
    }


    @Override
    public Iterator<Item> iterator() {

        // 返回逆序遍历的迭代器
        return new Iterator<Item>() {

            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };

    }
}*/
