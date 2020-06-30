package coffee.learn.recursion.principle;

import coffee.common.ListNode;

/**
 * @File    :   SwapNodesInPairs.java
 * @Time    :   2020/05/06 22:36:27
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, nextHead = head.next.next;
        newHead.next = head;
        head.next = swapPairs(nextHead);
        return newHead;
    }
}