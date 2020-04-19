package learn.binary_tree.exercise;

import common.TreeNode;
import common.TreePrinter;

/**
 * @File    :   LowestCommonAncestor.java
 * @Time    :   2020/04/19 22:52:08
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 5, 6, 2, 7, 4, 1, 0, 8};
        int[] in = new int[]{6, 5, 7, 2, 4, 3, 0, 1, 8};
        TreeNode tree = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        LowestCommonAncestor lowest = new LowestCommonAncestor();
        TreeNode node = lowest.lowestCommonAncestor(tree, tree.left, tree.right);
        System.out.println(node.val);

        node = lowest.lowestCommonAncestor(tree, tree.left, tree.left.right.right);
        System.out.println(node.val);
    }
}