package learn.recursion.recurrence;

import common.ListNode;

/**
 * @File    :   ReverseLinkedList.java
 * @Time    :   2020/05/07 22:18:18
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        return iterate(head);
        return recursive(head);
    }

    private ListNode recursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}