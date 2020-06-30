package coffee.p1to99;

import coffee.common.ListNode;

/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (44.96%)
 * Likes:    1454
 * Dislikes: 108
 * Total Accepted:    453.8K
 * Total Submissions: 1M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * 
 */

/**
 * @File    :   83.remove-duplicates-from-sorted-list.java
 * @Time    :   2020/06/18 22:03:45
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                cur = cur.next;
                continue;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }
}
// @lc code=end
