package coffee.learn.binarytree.traverse;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

/**
 * @File    :   MorrisInorderTraversal.java
 * @Time    :   2020/05/02 18:43:36
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MorrisInorderTraversal {
    /**
     * Morris Inorder Traversal
     *
     * 1.设当前结点为cur
     * 2.如果当前结点的左孩子为空，则输出当前结点并将其右孩子作为当前结点。
     * 3.如果当前结点的左孩子不为空，则找出左子树的最右结点，记为pre。
     *   a) 如果pre.right为空，则将pre.right指向当前结点，然后当前结点更新
     *      为当前结点的左孩子。
     *   b) 如果pre.right指向当前结点，则将pre.right重新设为空（恢复树的形状），
     *      输出当前结点，然后当前结点更新为当前结点的右孩子。
     * 4.重复步骤2、3，直到当前结点为空。
     *
     * @param root 树的根结点
     */
    public void inorder(TreeNode root) {
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
                    cur = cur.left;
                } else {
                    pre.right = null;
                    System.out.print(cur.val + " ");
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{6, 2, 1, 4, 3, 5, 7, 9, 8};
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(root);
        new MorrisInorderTraversal().inorder(root);
    }
}