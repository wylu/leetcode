package coffee.learn.binarytree.exercise;

import coffee.common.Node;

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

    public Node connectRecursive(Node root) {
        if (root == null) {
            return null;
        }
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;
        helper(node1.left, node1.right);
        helper(node2.left, node2.right);
        helper(node1.right, node2.left);
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
            sb.append('#').append(',');
            levelStart = levelStart.left;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] in = new int[]{4, 2, 5, 1, 6, 3, 7};
        Node tree = Node.mkTreeFromPreAndIn(pre, in);
        PopulateNextRightPointerInEachNode populate = new PopulateNextRightPointerInEachNode();
        populate.connect(tree);
        PopulateNextRightPointerInEachNode.prt(tree);

        tree = Node.mkTreeFromPreAndIn(pre, in);
        populate.connectRecursive(tree);
        PopulateNextRightPointerInEachNode.prt(tree);
    }
}