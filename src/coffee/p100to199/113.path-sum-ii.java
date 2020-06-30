package coffee.p100to199;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (45.02%)
 * Likes:    1475
 * Dislikes: 52
 * Total Accepted:    307.2K
 * Total Submissions: 681.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠      5
 * ⁠     / \
 * ⁠    4   8
 * ⁠   /   / \
 * ⁠  11  13  4
 *  ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
 * @File    :   113.path-sum-ii.java
 * @Time    :   2020/04/24 21:34:18
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution113 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new ArrayList<>());
        return res;
    }

    private void pathSum(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
                res.add(new ArrayList<>(path));
        } else {
            pathSum(root.left, sum - root.val, path);
            pathSum(root.right, sum - root.val, path);
        }
        path.remove(path.size() - 1);

    }
}
// @lc code=end

