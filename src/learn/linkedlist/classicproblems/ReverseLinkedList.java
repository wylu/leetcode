package learn.linkedlist.classicproblems;

import common.ListNode;

/**
 * @File    :   ReverseLinkedList.java
 * @Time    :   2020/05/17 11:18:41
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}