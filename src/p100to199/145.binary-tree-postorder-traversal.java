package p100to199;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (53.20%)
 * Likes:    1491
 * Dislikes: 80
 * Total Accepted:    349.9K
 * Total Submissions: 657.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [3,2,1]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
 * @File    :   145.binary-tree-postorder-traversal.java
 * @Time    :   2020/04/25 10:39:22
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution145 {
    /**
     * 创建一个辅助栈：
     * 1.将根结点压入栈
     * 2.弹出栈顶结点，将结点值插入结果序列的头部
     * 3.然后先将左子结点压入栈中（如果有）
     * 4.再将右子结点压入栈中（如果有）
     * 5.重复步骤2、3、4，直至栈空
     *
     * @param root 树的根结点
     * @return 后序遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }
}
// @lc code=end

