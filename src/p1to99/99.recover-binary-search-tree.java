package p1to99;

import common.TreeNode;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (38.20%)
 * Likes:    1314
 * Dislikes: 67
 * Total Accepted:    152.8K
 * Total Submissions: 400K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 *   1
 *  /
 * 3
 *  \
 *   2
 * 
 * Output: [3,1,null,null,2]
 * 
 *   3
 *  /
 * 1
 *  \
 *   2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠    3
 * ⁠   / \
 *   1   4
 *  /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠    2
 * ⁠   / \
 *   1   4
 *  /
 * ⁠3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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
 * @File    :   99.recover-binary-search-tree.java
 * @Time    :   2020/04/22 20:34:05
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution99 {
    /**
     * Morris Inorder Traversal
     *
     * 设当前结点为cur
     *
     * 1.如果当前结点的左孩子为空，则输出当前结点并将其右孩子作为当前结点。
     * 2.如果当前结点的左孩子不为空，则找出左子树的最右叶子结点，记为node。
     *   a) 如果node.right为空，则将node.right指向当前结点，然后当前结点更新
     *      为当前结点的左孩子。
     *   b) 如果node.right指向当前结点，则将node.right重新设为空（恢复树的形状），
     *      输出当前结点，然后当前结点更新为当前结点的右孩子。
     * 3.重复步骤1、2，直到当前结点为空。
     *
     * @param root 树的根结点
     */
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, pre = null;
        TreeNode first = null, second = null;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    tmp.right = null;
                    if (pre != null && pre.val > cur.val) {
                        if (first == null) {
                            first = pre;
                        }
                        second = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
// @lc code=end

