package com.chy.linkedList;

/**
 * 约瑟夫问题：从第一个人开始从 1 报数，报到 m 的人出列，下一位继续从 1 开始报数，报到 m 的人出列，依此继续
 *
 * @author chy
 * @date 2021/1/13 10:45
 */

public class Josephu {
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
     *  思路：
     *  添加 1 个元素和添加多个元素分开考虑
     *  当添加第一个元素时，自己与自己形成一个单向循环列表：
     *   first = new People(i);
     *   first.next = first;
     *   temp = first;
     * @param num
     */
    public void add(int num) {
        People temp = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                first = new People(i);
                first.next = first;
                temp = first;
            }else {
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