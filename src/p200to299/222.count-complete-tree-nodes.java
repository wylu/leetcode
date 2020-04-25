package p200to299;

import common.TreeNode;

/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (41.94%)
 * Likes:    1724
 * Dislikes: 183
 * Total Accepted:    191.6K
 * Total Submissions: 456.3K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠    1
 * ⁠   / \
 * ⁠  2   3
 * ⁠ / \  /
 * 4  5 6
 * 
 * Output: 6
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
 * @File    :   222.count-complete-tree-nodes.java
 * @Time    :   2020/04/25 19:46:54
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution222 {
    /**
     * 对于完全二叉树，只要遍历树的最左路径就可以得到树的高度。
     * 这里树的高度从0开始，只有一层的，树的高度为0；空树使用-1来区分。
     *
     * 检查右子树的高度是否比当前整个树的高度小1?
     * 设以当前结点为根的左子树的高度为h，则：
     * a)如果是，说明右子树的高度与左子树的高度相等，也说明了树的最后一层
     *   的最后一个结点必定在右子树中；这意味着左子树是一棵满二叉树，所以
     *   左子树的结点个数为2^h-1；当前树的总的结点个树为左子树的结点个数，
     *   加上1个根结点，再加上递归计算右子树中的结点个数。
     * b)如果不是，说明右子树是一棵满二叉树，而且高度为h-1，所以右子树的
     *   结点个数为2^(h-1)-1；而树的最后一层的最后一个结点必定在左子树中；
     *   所以当前树的总的结点个数为右子树的结点个数，加上1个根结点，再加上
     *   递归计算左子树中的结点个数。
     *
     * @param root 树的根结点
     * @return 树的结点总数
     */
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h < 0) {
            return 0;
        } else {
            return height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) :
                    (1 << (h - 1)) + countNodes(root.left);
        }
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

//    public int res = 0;
//
//    public int countNodes(TreeNode root) {
//        preorder(root);
//        return res;
//    }
//
//    private void preorder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        res++;
//        preorder(root.left);
//        preorder(root.right);
//    }
}
// @lc code=end

