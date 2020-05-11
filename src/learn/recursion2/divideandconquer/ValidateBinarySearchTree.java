package learn.recursion2.divideandconquer;

import common.TreeNode;

/**
 * @File    :   ValidateBinarySearchTree.java
 * @Time    :   2020/05/11 22:44:32
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        return valid(root.left, lower, root.val) && valid(root.right, root.val, upper);
    }
}