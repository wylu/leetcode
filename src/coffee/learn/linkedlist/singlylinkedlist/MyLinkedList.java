package coffee.learn.linkedlist.singlylinkedlist;

import coffee.common.ListNode;

/**
 * @File    :   MyLinkedList.java
 * @Time    :   2020/05/15 23:05:02
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MyLinkedList {
    private ListNode head = null;
    private ListNode tail = null;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {}

    /**
     * Get the value of the index-th node in the linked list.
     * @param index The index of node.
     * @return Node value. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = head;
        while (index > 0 && node != null) {
            node = node.next;
            index--;
        }
        return node == null ? -1 : node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     * @param val The value to add at head.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     * @param val The value to append at tail.
     */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended
     * to the end of linked list. If index is greater than the length, the
     * node will not be inserted.
     * @param index The index of node.
     * @param val The value to insert before.
     */
    public void addAtIndex(int index, int val) {
        ListNode pre = null, cur = head;
        while (index > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
            index--;
        }
        if (index > 0) return;

        ListNode node = new ListNode(val);
        if (pre == null) {
            node.next = cur;
            head = node;
        } else {
            pre.next = node;
            node.next = cur;
        }
        if (cur == null) tail = node;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * @param index The index of node to delete.
     */
    public void deleteAtIndex(int index) {
        ListNode pre = null, cur = head;
        while (index > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
            index--;
        }
        if (index > 0 || cur == null) return;
        if (pre == null) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            pre.next = cur.next;
            if (pre.next == null) tail = pre;
        }
    }

    /**
     * Get size of current linked list.
     * @return The size of linked list.
     */
    public int size() {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.deleteAtIndex(1);
        obj.addAtHead(4);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtHead(0);
        obj.addAtTail(6);
        System.out.println(obj.get(5));
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}