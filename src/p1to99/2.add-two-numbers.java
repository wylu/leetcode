package p1to99;

import common.ListNode;

/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.81%)
 * Likes:    7137
 * Dislikes: 1850
 * Total Accepted:    1.2M
 * Total Submissions: 3.8M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0, x, y;
        while (l1 != null || l2 != null) {
            x = l1 != null ? l1.val : 0;
            y = l2 != null ? l2.val : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry += x + y;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    // public static void testCase(int[] arr1, int[] arr2) {
    //     ListNode l1 = ListNode.genLinkedList(arr1);
    //     ListNode.prtLinkedList(l1);
    //     ListNode l2 = ListNode.genLinkedList(arr2);
    //     ListNode.prtLinkedList(l2);
    //     ListNode res = new Solution().addTwoNumbers(l1, l2);
    //     ListNode.prtLinkedList(res);
    //     System.out.println();
    // }

    // public static void main(String[] args) {
    //     testCase(new int[]{2, 4, 3}, new int[]{5, 6, 4});
    //     testCase(new int[]{2, 4, 3}, new int[]{5, 1, 7});
    // }
}
// @lc code=end

