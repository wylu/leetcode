package learn.binarytree.traverse;

import common.TreeNode;
import common.TreePrinter;

/**
 * @File    :   MorrisPreorderTraversal.java
 * @Time    :   2020/05/02 19:53:02
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MorrisPreorderTraversal {
    /**
     * Morris Preorder Traversal
     *
     * 1.设当前结点为cur
     * 2.如果当前结点的左孩子为空，则输出当前结点并将其右孩子作为当前结点。
     * 3.如果当前结点的左孩子不为空，则找出左子树的最右结点，记为pre。
     *   a) 如果pre.right为空，则将pre.right指向当前结点，输出当前结点，
     *      然后当前结点更新为当前结点的左孩子。
     *   b) 如果pre.right指向当前结点，则将pre.right重新设为空（恢复树的形状），
     *      然后当前结点更新为当前结点的右孩子。
     * 4.重复步骤2、3，直到当前结点为空。
     *
     * @param root 树的根结点
     */
    public void preorder(TreeNode root) {
        TreeNode cur = root, pre;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                // 找出左子树的最右结点，也即找出当前结点的前驱
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] in = new int[]{3, 2, 5, 4, 6, 1, 7, 9, 8};
        TreeNode root = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(root);
        new MorrisPreorderTraversal().preorder(root);
    }
}