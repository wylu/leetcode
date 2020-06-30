package coffee.p400to499;

import coffee.common.TreeNode;

import java.util.HashMap;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (45.24%)
 * Likes:    2974
 * Dislikes: 234
 * Total Accepted:    164.4K
 * Total Submissions: 363.1K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠      10
 * ⁠     /  \
 * ⁠    5   -3
 * ⁠   / \    \
 * ⁠  3   2   11
 * ⁠ / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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
 * @File    :   437.path-sum-iii.java
 * @Time    :   2020/04/28 22:30:45
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution437 {
    /**
     * 1.从路径中间的任何节点到当前节点的总和=从根到当前节点的总和
     *   与中间节点的前缀总和之差。
     * 2.使用一个哈希表存储<prefix sum，frequency>对，其中prefix sum
     *   为从根到当前节点的总和。
     * 3.我们正在寻找一些总计给定目标值的连续节点，这意味着1中讨论的
     *   差异应等于目标值。
     * 4.如果地图中存在当前总和与目标值之间的差异，则路径中间必须存在
     *   一个节点，这样从该节点到当前节点的总和等于目标值。
     * 5.每次递归都返回以当前节点为根的子树中有效路径的总数。这个总和
     *   可以分为三个部分：
     *   -以当前节点的左子节点为根的子树中的有效路径总数
     *   -子树中以当前节点的右子节点为根的有效路径总数
     *   -当前节点结束的有效路径数
     *
     * @param root 树的根结点点
     * @param sum 路径和
     * @return 满足路径和的路径总数
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSum(root, sum, 0, map);
    }

    private int pathSum(TreeNode root, int sum, int prefixSum,
                        HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        prefixSum += root.val;
        int numPathToCur = map.getOrDefault(prefixSum - sum, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        int res = numPathToCur + pathSum(root.left, sum, prefixSum, map) +
                pathSum(root.right, sum, prefixSum, map);
        map.put(prefixSum, map.get(prefixSum) - 1);
        return res;
    }
}
// @lc code=end

