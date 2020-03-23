package common;

/**
 * @File    :   Tree.java
 * @Time    :   2020/03/23 17:46:15
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class Tree {
    private static TreeNode mk(int[] pre, int[] in,
                               int startPre, int endPre,
                               int startIn, int endIn) {
        if (startPre == endPre) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        // 中序遍历序列根结点索引
        int idx = startIn;
        while (idx < endIn && in[idx] != root.val) {
            idx++;
        }

        // 左子树序列长度
        int llen = idx - startIn;
        // 左右子树序列中点（右子树序列起始点）
        int mpre = startPre + 1 + llen;
        root.left = mk(pre, in, startPre + 1, mpre, startIn, idx - 1);
        root.right = mk(pre, in, mpre, endPre, idx + 1, endIn);
        return root;
    }

    /**
     * 利用前序遍历序列和中序遍历序列构建一颗二叉树
     * 
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @return
     */
    public static TreeNode mkTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length) {
            return null;
        }
        return mk(pre, in, 0, pre.length, 0, in.length);
    }
}
