package learn.linkedlist.classicproblems;

import common.ListNode;

/**
 * @File    :   PalindromeLinkedList.java
 * @Time    :   2020/05/17 12:37:08
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        int mid = (len + 1) / 2;
        node = head;
        while (mid-- > 0) node = node.next;

        ListNode pre = null, cur = node;
        while (cur != null) {
            node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }

        ListNode ph = head, pt = pre;
        while (pt != null) {
            if (pt.val != ph.val) return false;
            pt = pt.next;
            ph = ph.next;
        }
        return true;
    }
}