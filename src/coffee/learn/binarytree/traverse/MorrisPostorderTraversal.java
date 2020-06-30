package coffee.learn.binarytree.traverse;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

/**
 * @File    :   MorrisPostorderTraversal.java
 * @Time    :   2020/05/02 20:16:09
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MorrisPostorderTraversal {
    /**
     * Morris Postorder Traversal
     *
     * 1.创建一个临时结点dump，令其左孩子是root，设当前结点为cur
     * 2.如果当前结点的左孩子为空，则将其右孩子作为当前结点。
     * 3.如果当前结点的左孩子不为空，则找出左子树的最右结点，记为pre。
     *   a) 如果pre.right为空，则将pre.right指向当前结点，
     *      然后当前结点更新为当前结点的左孩子。
     *   b) 如果pre.right指向当前结点，则将pre.right重新设为空（恢复树的形状），
     *      倒序输出从当前节点的左孩子到pre这条路径上的所有节点，
     *      然后当前结点更新为当前结点的右孩子。
     * 4.重复步骤2、3，直到当前结点为空。
     *
     * @param root 树的根结点
     */
    public void postorder(TreeNode root) {
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode cur = dump, pre;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    printReverse(cur.left);
                    cur = cur.right;
                }
            }
        }
    }

    private void printReverse(TreeNode root) {
        TreeNode head = reverse(root);
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        reverse(head);
    }

    /**
     * 反转链表
     * @param root 链表头结点
     * @return 反转后的链表头结点
     */
    private TreeNode reverse(TreeNode root) {
        TreeNode pre = null, cur = root;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 5, 2, 4, 3, 9, 8, 6, 7};
        int[] post = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeNode.buildFromInAndPost(in, post);
        TreePrinter.prtHorizontalStyle(root);
        new MorrisPostorderTraversal().postorder(root);
    }
}