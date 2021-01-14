package com.chy.stack;

/**
 * 数组模拟栈
 *
 * @author chy
 * @date 2021/1/13 19:29
 */

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();
//      栈满测试
//      stack.push(5);
        System.out.println("出栈测试");
        System.out.println("出栈的数据是： " + stack.pop());
        System.out.println("出栈的数据是： " + stack.pop());
        System.out.println("出栈的数据是： " + stack.pop());
        System.out.println("出栈的数据是： " + stack.pop());
        System.out.println("出栈的数据是： " + stack.pop());
//      栈空测试
        stack.pop();

    }

}

class Stack {
    // 栈的大小
    private int maxSize;
    // 模拟栈的数组
    private int stack[];
    // 栈顶
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历
     */
    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(i + "---" + stack[i]);
        }
    }
}
