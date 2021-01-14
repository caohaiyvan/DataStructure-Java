package com.chy.linkedList;

/**
 * 双向链表
 *
 * @author chy
 * @date 2021/1/12 15:32
 */

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "及时雨", "宋江");
        HeroNode2 hero2 = new HeroNode2(2, "玉麒麟", "卢俊义");
        HeroNode2 hero6 = new HeroNode2(6, "豹子头", "林冲");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // 添加测试
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero6);
        doubleLinkedList.list();
        System.out.println("按编号顺序添加元素");
        doubleLinkedList.addByOrder(new HeroNode2(3, "花和尚", "鲁智深"));
        doubleLinkedList.addByOrder(new HeroNode2(4, "玉麒麟", "卢俊义"));
        doubleLinkedList.addByOrder(new HeroNode2(7, "矮脚虎", "黄英"));
        doubleLinkedList.addByOrder(new HeroNode2(3, "矮脚虎", "黄英"));
        doubleLinkedList.list();
        System.out.println("修改元素");
        doubleLinkedList.update(new HeroNode2(3, "小李广", "花荣"));
        doubleLinkedList.list();
        System.out.println("删除链表尾部元素");
        doubleLinkedList.delAtEnd(doubleLinkedList.getHead());
        doubleLinkedList.list();
        System.out.println("删除指定元素");
        doubleLinkedList.delete(new HeroNode2(3, "小李广", "花荣"));
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 链表尾部添加元素
     *
     * @param hero
     */
    public void add(HeroNode2 hero) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = hero;
        hero.pre = temp;
    }

    /**
     * 按照编号顺序添加元素
     *
     * @param hero
     */
    public void addByOrder(HeroNode2 hero) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no == hero.no) {
                System.out.println("元素已存在");
                return;
            }
            if (temp.next.no > hero.no) {
                break;
            }
            temp = temp.next;
        }
        hero.next = temp.next;
        temp.next = hero;
        temp.next.pre = hero;
        hero.pre = temp;

    }

    /**
     * 修改元素:根据编号进行修改
     */
    public void update(HeroNode2 hero) {
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == hero.no) {
                temp.name = hero.name;
                temp.nickName = hero.nickName;
                break;

            }
            temp = temp.next;

        }
    }

    /**
     * 从链表末尾删除元素
     */
    public void delAtEnd(HeroNode2 head) {
        HeroNode2 temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    /**
     * 删除指定元素:双向链表可进行自我删除：即找到的temp是要删除的节点
     */
    public void delete(HeroNode2 hero) {
        HeroNode2 temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp.no != hero.no) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("元素不存在");
                return;
            }
        }
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;

    }


    /**
     * 遍历
     */

    public void list() {
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }

}

class HeroNode2 {
    // 序号
    public int no;
    // 昵称
    public String nickName;
    // 姓名
    public String name;
    // pre
    public HeroNode2 pre;
    // next域
    public HeroNode2 next;

    public HeroNode2(int no, String nickName, String name) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
