package coffee.learn.linkedlist.classicproblems;

import coffee.common.ListNode;

/**
 * @File    :   OddEvenLinkedList.java
 * @Time    :   2020/05/17 12:18:35
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode behind = head, front = head.next, evenHead = head.next;
        while (front != null && front.next != null) {
            behind.next = front.next;
            behind = behind.next;
            front.next = behind.next;
            front = front.next;
        }
        behind.next = evenHead;
        return head;
    }
}