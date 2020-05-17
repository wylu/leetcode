package learn.linkedlist.conclusion;

/**
 * @File    :   CopyListWithRandomPointer.java
 * @Time    :   2020/05/17 17:24:07
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // copy each node
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        // copy random reference
        cur = head;
        while (cur != null) {
            Node node = cur.next;
            if (cur.random != null) node.random = cur.random.next;
            cur = node.next;
        }

        // separate
        cur = head;
        Node copyHead = cur.next;
        Node node = copyHead;
        while (cur != null) {
            cur.next = node.next;
            cur = cur.next;
            if (cur != null) {
                node.next = cur.next;
                node = node.next;
            }
        }
        return copyHead;
    }
}