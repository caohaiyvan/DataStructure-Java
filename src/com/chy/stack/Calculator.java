package com.chy.stack;

/**
 * 栈实现计算器
 * 思路：1、创建两个栈，一个数栈存放数字，一个符号栈存放运算符，遍历需要计算的表达式，若为数字就入数栈，若为运算符就入符号栈
 * 2、入符号栈：若符号栈为空：则直接入栈
 * 符号栈不空：a：若当前符号的优先级小于等于栈顶符号的优先级，就弹出数栈中的两个数字和符号栈中的栈顶符号进行运算，并把运算结果入数栈，当前符号入符号栈
 * b: 若当前符号的优先级大于栈顶符号的优先级,则直接入栈
 * 3、遍历完要计算的表达式后，弹出数栈和符号栈中的元素进行计算，最后数栈中只有一个元素即为计算结果
 *
 * @author chy
 * @date 2021/1/15 10:19
 */

public class Calculator {
}

class Stack2 {
    // 栈的大小
    private int maxSize;
    // 模拟栈的数组
    private int stack[];
    // 栈顶
    private int top = -1;

    public Stack2(int maxSize) {
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
     * 查看栈顶元素
     *
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        return stack[top];
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
