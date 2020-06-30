package coffee.common;

/**
 * @File    :   DoublyListNode.java
 * @Time    :   2020/05/17 12:59:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class DoublyListNode {
    public int val;
    public DoublyListNode next;
    public DoublyListNode prev;

    public DoublyListNode(int val) {
        this.val = val;
    }

    public static DoublyListNode genLinkedList(int ... nums) {
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode pre = null, cur = head;
        for (int x : nums) {
            cur.next = new DoublyListNode(x);
            cur = cur.next;
            cur.prev = pre;
            pre = cur;
        }
        return head.next;
    }

    public static void prtFromHeadToTail(DoublyListNode head) {
        if (head == null) {
            System.out.println("Empty Double Linked List.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append(head.val);
        System.out.println(sb.toString());
    }

    public static void prtFromTailToHead(DoublyListNode tail) {
        if (tail == null) {
            System.out.println("Empty Double Linked List.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (tail.prev != null) {
            sb.append(tail.val).append(" -> ");
            tail = tail.prev;
        }
        sb.append(tail.val);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        DoublyListNode head = DoublyListNode.genLinkedList(1, 2, 3, 4, 5);
        DoublyListNode.prtFromHeadToTail(head);
        while (head.next != null) head = head.next;
        DoublyListNode.prtFromTailToHead(head);
    }
}