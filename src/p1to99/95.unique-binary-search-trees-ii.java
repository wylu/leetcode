package p1to99;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (39.14%)
 * Likes:    1869
 * Dislikes: 150
 * Total Accepted:    178.4K
 * Total Submissions: 455.9K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
  * @File    :   95.unique-binary-search-trees-ii.java
  * @Time    :   2020/04/21 23:16:00
  * @Author  :   wylu
  * @Version :   1.0
  * @Contact :   15wylu@gmail.com
  * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
  * @Desc    :
  */
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int begin, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (begin > end) {
            list.add(null);
        }
        for (int mid = begin; mid <= end; mid++) {
            List<TreeNode> leftList = generate(begin, mid - 1);
            List<TreeNode> rightList = generate(mid + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
// @lc code=end

