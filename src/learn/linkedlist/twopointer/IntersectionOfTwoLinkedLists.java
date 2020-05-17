package learn.linkedlist.twopointer;

import common.ListNode;

/**
 * @File    :   IntersectionOfTwoLinkedLists.java
 * @Time    :   2020/05/17 10:44:09
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        int lena = 0, lenb = 0;
        while (pa != null) {
            lena++;
            pa = pa.next;
        }
        while (pb != null) {
            lenb++;
            pb = pb.next;
        }

        pa = headA;
        pb = headB;
        if (lena > lenb) {
            for (int i = 0; i < lena - lenb; i++) pa = pa.next;
        } else {
            for (int i = 0; i < lenb - lena; i++) pb = pb.next;
        }
        while (pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa == pb ? pa : null;
    }
}