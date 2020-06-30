package coffee.learn.linkedlist.conclusion;

import java.util.LinkedList;

/**
 * @File    :   FlattenAMultilevelDoublyLinkedList.java
 * @Time    :   2020/05/17 16:50:40
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        LinkedList<Node> stack = new LinkedList<>();
        Node pre = null, cur = head;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                cur.prev = pre;
                pre = cur;
                if (cur.child != null) {
                    stack.push(cur.next);
                    cur = cur.child;
                    pre.next = cur;
                    pre.child = null;
                } else {
                    cur = cur.next;
                }
            } else {
                cur = stack.pop();
                if (cur != null) pre.next = cur;
            }
        }
        return head;
    }
}