package com.chy.linkedList;

/**
 * 单向环形链表
 *
 * @author chy
 * @date 2021/1/13 10:45
 */

public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(10);
        circleSingleLinkedList.list();
    }

}

class CircleSingleLinkedList {
    People first = new People(0);

    /**
     * 添加 num 个元素（链表不带头节点）
     * 思路：
     * 添加 1 个元素和添加多个元素分开考虑
     * 当添加第一个元素时，自己与自己形成一个单向循环列表：
     * first = new People(i);
     * first.next = first;
     * temp = first;
     *
     * @param num
     */
    public void add(int num) {
        People temp = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                first = new People(i);
                first.next = first;
                temp = first;
            } else {
                temp.next = new People(i);
                temp.next.next = first;
                temp = temp.next;
            }


        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        People temp = first;
        while (true) {
            System.out.println(temp);
            // 当到最后一个节点指向第一个节点时遍历完成
            if (temp.next == first) {
                break;
            }
            temp = temp.next;

        }
    }

}

class People {
    public int no;
    public People next;

    public People(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "People{" +
                "no=" + no +
                '}';
    }
}