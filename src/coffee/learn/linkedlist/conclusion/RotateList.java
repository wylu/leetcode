package coffee.learn.linkedlist.conclusion;

import coffee.common.ListNode;

/**
 * @File    :   RotateList.java
 * @Time    :   2020/05/17 17:50:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) return null;

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        if (k == 0 || k % len == 0) return head;

        k = len - k % len;
        ListNode node = head;
        while (k-- > 1) node = node.next;
        ListNode rotateHead = node.next;
        node.next = null;
        tail.next = head;
        return rotateHead;
    }
}