package learn.binary_tree.traverse;

import java.util.List;
import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * @File    :   PreorderTraversal.java
 * @Time    :   2020/03/23 17:39:43
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
class Solution {
    public void recursive(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        recursive(root.left, res);
        recursive(root.right, res);
    }

    public List<Integer> iterate(TreeNode root) {
        return null;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }
}