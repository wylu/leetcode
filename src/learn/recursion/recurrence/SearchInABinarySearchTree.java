package learn.recursion.recurrence;

import common.TreeNode;

/**
 * @File    :   SearchInABinarySearchTree.java
 * @Time    :   2020/05/07 22:38:10
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode left = searchBST(root.left, val);
        return left != null ? left : searchBST(root.right, val);
    }
}