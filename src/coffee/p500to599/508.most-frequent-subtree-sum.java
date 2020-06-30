package coffee.p500to599;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (56.92%)
 * Likes:    555
 * Dislikes: 107
 * Total Accepted:    65.4K
 * Total Submissions: 114.8K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠  5
 * ⁠ /  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠  5
 *  ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * @File    :   508.most-frequent-subtree-sum.java
 * @Time    :   2020/04/29 22:31:07
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution508 {
    private ArrayList<Integer> sums = new ArrayList<>();
    private int maxCnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        postorder(root, map);
        int[] res = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            res[i] = sums.get(i);
        }
        return res;
    }

    private int postorder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = postorder(root.left, map);
        int right = postorder(root.right, map);
        int cur = left + right + root.val;
        int cnt = map.getOrDefault(cur, 0) + 1;
        if (cnt > maxCnt) {
            maxCnt = cnt;
            sums.clear();
            sums.add(cur);
        } else if (cnt == maxCnt) {
            sums.add(cur);
        }
        map.put(cur, cnt);
        return cur;
    }
}
// @lc code=end

