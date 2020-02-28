package p1to99;

import common.ListNode;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * @author wylu
 */
public class AddTwoNumbers {

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

    public static void testCase(int[] arr1, int[] arr2) {
        ListNode l1 = ListNode.genLinkedList(arr1);
        ListNode.prtLinkedList(l1);
        ListNode l2 = ListNode.genLinkedList(arr2);
        ListNode.prtLinkedList(l2);
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode.prtLinkedList(res);
        System.out.println();
    }

    public static void main(String[] args) {
        testCase(new int[]{2, 4, 3}, new int[]{5, 6, 4});
        testCase(new int[]{2, 4, 3}, new int[]{5, 1, 7});
    }

}
