package coffee.learn.linkedlist.twopointer;

import coffee.common.ListNode;

/**
 * @File    :   LinkedListCycleII.java
 * @Time    :   2020/05/16 22:56:21
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }

        int loop = 1;
        fast = fast.next;
        while (fast != slow) {
            loop++;
            fast = fast.next;
        }

        slow = fast = head;
        while (loop-- > 0) fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}