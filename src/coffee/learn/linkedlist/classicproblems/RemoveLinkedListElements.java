package coffee.learn.linkedlist.classicproblems;

import coffee.common.ListNode;

/**
 * @File    :   RemoveLinkedListElements.java
 * @Time    :   2020/05/17 11:22:46
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) pre.next = cur.next;
            else pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}