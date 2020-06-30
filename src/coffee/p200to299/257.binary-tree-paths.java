package coffee.p200to299;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (49.77%)
 * Likes:    1442
 * Dislikes: 90
 * Total Accepted:    293.8K
 * Total Submissions: 589.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠   1
 *  ⁠/   \
 * 2     3
 * ⁠ \
 * ⁠  5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
 * @File    :   257.binary-tree-paths.java
 * @Time    :   2020/04/26 22:42:31
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution257 {
    public List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        preorder(root, new ArrayList<>());
        return res;
    }

    private void preorder(TreeNode root, ArrayList<String> seq) {
        seq.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", seq));
        }
        if (root.left != null) {
            preorder(root.left, seq);
        }
        if (root.right != null) {
            preorder(root.right, seq);
        }
        seq.remove(seq.size() - 1);
    }
}
// @lc code=end

