package coffee.p100to199;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (45.88%)
 * Likes:    1706
 * Dislikes: 88
 * Total Accepted:    324.2K
 * Total Submissions: 706.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
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
 * @File    :   103.binary-tree-zigzag-level-order-traversal.java
 * @Time    :   2020/04/23 22:44:54
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution103 {
    /**
     * 之字形打印二叉树
     * 使用两个辅助栈，在打印某一层结点时，把下一层的结点保存到相应的栈里。
     * 如果当前打印的是奇数层，则先保存左子结点再保存右子结点到第一个栈里；
     * 如果当前打印的是偶数层，则先保存右子结点在保存左子结点到第二个栈里。
     * @param root 树的根结点
     * @return 二维列表
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> level = new ArrayList<>();
        ArrayList<LinkedList<TreeNode>> stacks = new ArrayList<>();
        stacks.add(new LinkedList<>());
        stacks.add(new LinkedList<>());
        int cur = 0, next = 1;
        stacks.get(cur).push(root);
        while (!stacks.get(cur).isEmpty() || !stacks.get(next).isEmpty()) {
            TreeNode node = stacks.get(cur).pop();
            level.add(node.val);
            if (cur == 0) {
                if (node.left != null)  {
                    stacks.get(next).push(node.left);
                }
                if (node.right != null) {
                    stacks.get(next).push(node.right);
                }
            } else {
                if (node.right != null) {
                    stacks.get(next).push(node.right);
                }
                if (node.left != null) {
                    stacks.get(next).push(node.left);
                }
            }
            if (stacks.get(cur).isEmpty()) {
                cur = 1 - cur;
                next = 1 - next;
                res.add(level);
                level = new ArrayList<>();
            }
        }
        return res;
    }
}
// @lc code=end

