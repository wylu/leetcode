package coffee.p100to199;

import coffee.common.TreeNode;

import java.util.LinkedList;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (45.99%)
 * Likes:    3551
 * Dislikes: 83
 * Total Accepted:    590.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠    1
 * ⁠   / \
 * ⁠  2   2
 * ⁠ / \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠    1
 * ⁠   / \
 * ⁠  2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Follow up: Solve it both recursively and iteratively.
 * 
 */

// @lc code=start
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
 * @File    :   101.symmetric-tree.java
 * @Time    :   2020/04/23 22:10:41
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution101 {

    /**
     * 递归地判断左右子树是否对称
     * @param r1 左子树根结点
     * @param r2 右子树根结点
     * @return bool
     */
    private boolean recursive(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return (r1.val == r2.val) && recursive(r1.left, r2.right) && recursive(r1.right, r2.left);
    }

    /**
     * 迭代地判断树是否对称
     * @param root 树的根结点
     * @return bool
     */
    private boolean iterate(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            if (r1 == null && r2 == null) {
                continue;
            }
            if (r1 == null || r2 == null || r1.val != r2.val) {
                return false;
            }
            queue.offer(r1.left);
            queue.offer(r2.right);
            queue.offer(r1.right);
            queue.offer(r2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return recursive(root.left, root.right);
        return iterate(root);
    }
}
// @lc code=end

