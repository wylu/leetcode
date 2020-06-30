package coffee.learn.recursion.conclusion;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   UniqueBinarySearchTreeII.java
 * @Time    :   2020/05/09 22:38:57
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int begin, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (begin > end) {
            trees.add(null);
            return trees;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftTrees = generate(begin, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);
            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}