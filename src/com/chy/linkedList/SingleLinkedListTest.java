package com.chy.linkedList;

import java.util.Stack;

/**
 * 单链表
 *
 * @author chy
 * @date 2021/1/8 13:57
 */

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "及时雨", "宋江");
        HeroNode hero2 = new HeroNode(2, "玉麒麟", "卢俊义");
        HeroNode hero6 = new HeroNode(6, "豹子头", "林冲");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 添加测试
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero6);
        singleLinkedList.list();
        System.out.println();
        // 修改测试
        singleLinkedList.update(new HeroNode(2, "智多星", "吴用"));
        singleLinkedList.list();
        // 按顺序添加测试
        System.out.println();
        singleLinkedList.sortAdd(new HeroNode(3, "花和尚", "鲁智深"));
        singleLinkedList.sortAdd(new HeroNode(4, "玉麒麟", "卢俊义"));
        singleLinkedList.sortAdd(new HeroNode(7, "矮脚虎", "黄英"));
        singleLinkedList.sortAdd(new HeroNode(3, "矮脚虎", "黄英"));
        singleLinkedList.list();
        System.out.println();
        // 删除节点测试
        singleLinkedList.deleteAtEnd();
        singleLinkedList.list();
        System.out.println();
        // 删除指定节点
        singleLinkedList.delete(new HeroNode(4, "玉麒麟", "卢俊义"));
        singleLinkedList.list();
        // 单链表中有效节点个数
        HeroNode heroNode = new HeroNode(2, "智多星", "吴用");
        System.out.println("单链表中有效节点个数: " + singleLinkedList.sum(singleLinkedList.getHead()));
        // 查找单链表中倒数第k个元素
        System.out.println(singleLinkedList.findLastNode(singleLinkedList.getHead(), 3));
        System.out.println(singleLinkedList.findLastNode(singleLinkedList.getHead(), 1));
        System.out.println();
        // 单链表的反转
        System.out.println("单链表中的元素-------");
        singleLinkedList.list();
        System.out.println("反转后-------");
        singleLinkedList.reverse(singleLinkedList.getHead());
        singleLinkedList.list();
        /*
        System.out.println();
        // 逆序打印
        singleLinkedList.reversePrint(singleLinkedList.getHead());
*/
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 直接添加到链表的尾部
     */

    public void add(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = hero;
                break;

            }
            temp = temp.next;


        }
    }

    /**
     * 根据排名添加到指定位置
     * <p>
     * 无论temp是否为最后一个节点，添加元素的方式都是：新节点.next = temp.next , temp.next = 新节点
     * hero.next = temp.next;
     * temp.next = hero;
     */

    public void sortAdd(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                hero.next = temp.next;
                temp.next = hero;
                break;
            }

            if (temp.no == hero.no) {
                System.out.printf("元素已存在%d\n", temp.no);
                break;
            }
            if (temp.next != null && temp.next.no > hero.no) {
                hero.next = temp.next;
                temp.next = hero;
                break;
            }
            temp = temp.next;

        }
    }

    /**
     * 遍历
     */

    public void list() {
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 修改节点
     */

    public void update(HeroNode newHero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == newHero.no) {
                temp.next.name = newHero.name;
                temp.next.nickName = newHero.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除末尾节点
     */

    public void deleteAtEnd() {
        HeroNode temp = head;
        while (true) {
            // 找到被删除节点的前一个节点
            if (temp.next.next == null) {
                temp.next = null;
                break;
            }

            temp = temp.next;
        }
    }

    /**
     * 删除指定节点
     * 找到要删除节点的前一个结点，使其直接指向该节点的下一个节点的下一个节点
     * temp.next = temp.next.next;
     */

    public void delete(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            // 找到了最后的一个节点
            if (temp.next == null) {
                System.out.println("节点不存在");
                break;
            }
            if (temp.next.no == hero.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取单链表中有效节点的个数（不包括头节点）
     */

    public int sum(HeroNode head) {
        int sum = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            sum++;
            temp = temp.next;
        }
        return sum;

    }

    /**
     * 查找单链表中倒数第k个元素:
     * 查找单链表中倒数第k个元素需要遍历链表长度 - k 个元素，第链表长度 - k + 1 个元素即为倒数第k个元素
     */

    public HeroNode findLastNode(HeroNode head, int k) {

        HeroNode temp = head;
        // 统计遍历了几个节点
//        int count = 0; 改掉
        int sum = sum(head);
        if (k <= 0 || k > sum) {
            return null;
        }
        /* 改为for循环实现
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
            if (count == sum - k) {
                break;
            }


        }
        return temp.next;
        */
        // 改后:添加如下
        if (head.next == null) {
            return null;
        }
        for (int i = 0; i < sum - k + 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     *  单链表的反转：新建一个链表，遍历原链表元素依次插入元素到新链表头节点之后，最后再使原链表的头节点指向新链表的第一个元素
     *  注意：需要先备份一份temp的下一个元素，否则在第一次temp添加到新链表时会使temp.next为空，导致原链表断开
     *  因此需要备份，并且添加到新链表后再使辅助变量temp指向刚刚备份的元素，继续遍历原链表元素，重复上述步骤进行添加
     */
    public void reverse(HeroNode head) {
        HeroNode newHead = new HeroNode(109, "109", "109");
        HeroNode temp = head.next;
        HeroNode temp1 = null;
        // 如果链表为空或链表中只有一个元素则不需要进行反转
        if (temp == null || temp.next == null) {
            return;
        }
        while (true) {
            if (temp != null) {
                temp1 = temp.next;
            }
            if(temp == null){
                break;
            }

            temp.next = newHead.next;
            newHead.next = temp;
            temp = temp1;

        }
        // 原链表的头执行新链表的第一个元素
        head.next = newHead.next;


    }

    /**
     * 反向打印单链表
     * 1、使用栈:利用栈后进先出的特点
     */
    public void reversePrint(HeroNode head) {
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}

class HeroNode {
    // 序号
    public int no;
    // 昵称
    public String nickName;
    // 姓名
    public String name;
    // next域
    public HeroNode next;

    public HeroNode(int no, String nickName, String name) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
