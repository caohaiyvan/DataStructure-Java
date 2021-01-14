package com.chy.queue;

/**
 * 数组模拟队列
 * 此种实现方式存在问题：为一次性数组，当队列已满，进行出队操作后不能再继续向队列中添加元素
 * 改进：环形队列（CircleArrayQueue）
 *
 * @author chy
 * @date 2021/1/8 10:55
 */

public class ArrayQueue {
    // 队列的最大容量
    private int maxSize;
    // 队首元素的前一个位置
    private int front;
    // 队尾元素的位置
    private int rear;
    private int arr[];

    // 初始化相应的值
    public ArrayQueue(int arrSize) {
        maxSize = arrSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;

    }

    // 判空
    public boolean isEmpty() {
        return front == rear;
    }

    // 判满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 入队
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear + 1] = n;
    }

    // 出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}
