package coffee.p100to199;

import coffee.common.Node;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (37.66%)
 * Likes:    1354
 * Dislikes: 171
 * Total Accepted:    235K
 * Total Submissions: 623.7K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * Given a binary tree
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not
 * count as extra space for this problem.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/**
 * @File    :   117.populating-next-right-pointers-in-each-node-ii.java
 * @Time    :   2020/04/25 09:07:19
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
class Solution117 {
    public Node connect(Node root) {
        Node nextHeadDummy = new Node(0);
        Node nextLevelCur = nextHeadDummy;
        Node cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    nextLevelCur.next = cur.left;
                    nextLevelCur = nextLevelCur.next;
                }
                if (cur.right != null) {
                    nextLevelCur.next = cur.right;
                    nextLevelCur = nextLevelCur.next;
                }
                cur = cur.next;
            }
            cur = nextHeadDummy.next;
            nextHeadDummy.next = null;
            nextLevelCur = nextHeadDummy;
        }
        return root;
    }
}
// @lc code=end

