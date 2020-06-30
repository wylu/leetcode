package coffee.p300to399;

import coffee.common.TreeNode;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (50.01%)
 * Likes:    2321
 * Dislikes: 49
 * Total Accepted:    143.4K
 * Total Submissions: 286.5K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3,null,3,null,1]
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \ 
 * ⁠    3   1
 * 
 * Output: 7 
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,5,1,3,null,1]
 * 
 *     3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \ 
 * ⁠1   3   1
 * 
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
 * @File    :   337.house-robber-iii.java
 * @Time    :   2020/04/27 21:44:55
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution337 {
    /**
     * 终止条件：什么时候无需任何计算就能知道rob(root)的答案？
     * 当然，当树是空的时，我们没有什么可抢的，所以钱是零。
     *
     * 递归关系：即如何从rob(root.left)，rob(root.right)，...等获取rob(root)。
     * 从树根的角度来看，最后只有两种情况：root是否被抢。
     * a)如果root被抢，由于“我们不能抢劫任何两个直接链接的房屋”的限制，下一级
     *   可用的子树将是四个“孙子树”(root.left.left, root.left.right,
     *    root.right.left, root.right.right)
     * b)如果未抢走root，则下一级可用子树将只是两个“子树”(root.left, root.right)
     *   我们只需要选择产生大量资金的方案即可。
     *
     * @param root 树的根结点
     * @return rob最大值
     */
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
// @lc code=end

