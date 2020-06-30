package coffee.common;

/**
 * @File    :   ListNode.java
 * @Time    :   2020/03/23 17:37:46
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode genLinkedList(int ... nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int x : nums) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return head.next;
    }

    public static void prtLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("Empty Linked List.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append(head.val);
        System.out.println(sb.toString());
    }
}
