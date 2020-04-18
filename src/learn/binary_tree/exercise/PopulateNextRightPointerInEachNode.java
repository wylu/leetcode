package learn.binary_tree.exercise;

import common.Node;

import java.util.LinkedList;

/**
 * @File    :   PopulateNextRightPointerInEachNode.java
 * @Time    :   2020/04/18 22:37:09
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PopulateNextRightPointerInEachNode {
    public Node connect(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) {
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    public static void prt(Node root) {
        if (root == null) {
            return;
        }
        Node levelStart = root;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                sb.append(cur.val).append(',');
                cur = cur.next;
            }
            sb.append('#');
            levelStart = levelStart.left;
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        Node tree = Node.mkTree(pre, in);
        PopulateNextRightPointerInEachNode populate = new PopulateNextRightPointerInEachNode();
        populate.connect(tree);
        PopulateNextRightPointerInEachNode.prt(tree);
    }
}