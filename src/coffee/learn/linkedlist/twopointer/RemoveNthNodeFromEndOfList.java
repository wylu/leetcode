package coffee.learn.linkedlist.twopointer;

import coffee.common.ListNode;

/**
 * @File    :   RemoveNthNodeFromEndOfList.java
 * @Time    :   2020/05/17 10:54:58
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, behind = head;
        while (n-- > 0) front = front.next;
        if (front == null) return behind.next;

        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }

        ListNode node = behind.next;
        behind.next = node.next;
        return head;
    }
}