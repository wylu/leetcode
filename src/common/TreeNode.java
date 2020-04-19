package common;

import java.util.HashMap;

/**
 * @File    :   TreeNode.java
 * @Time    :   2020/03/23 17:39:25
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 利用前序遍历序列和中序遍历序列构建一颗二叉树
     * 前提：所有结点的值唯一
     *
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @return 返回树的根结点
     */
    public static TreeNode mkTreeFromPreAndIn(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(in.length);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return mkTreeFromPreAndIn(0, pre, 0, pre.length - 1, map);
    }

    private static TreeNode mkTreeFromPreAndIn(int si, int[] pre, int sp, int ep,
                                               HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(pre[sp]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = mkTreeFromPreAndIn(si, pre, sp + 1, sp + leftLen, map);
        root.right = mkTreeFromPreAndIn(idx + 1, pre, sp + leftLen + 1, ep, map);
        return root;
    }

    /**
     * 利用前序遍历序列和中序遍历序列构建一颗二叉树
     *
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @return 返回树的根结点
     */
    public static TreeNode buildFromPreAndIn(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return buildFromPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode buildFromPreAndIn(int[] pre, int startPre, int endPre,
                                              int[] in, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        // 中序遍历序列根结点索引
        int idx = startIn;
        while (idx <= endIn && in[idx] != root.val) {
            idx++;
        }

        // 左子树序列长度
        int llen = idx - startIn;
        // 左右子树序列中点（右子树序列起始点）
        int mpre = startPre + 1 + llen;
        root.left = buildFromPreAndIn(pre, startPre + 1, mpre - 1, in, startIn, idx - 1);
        root.right = buildFromPreAndIn(pre, mpre, endPre, in, idx + 1, endIn);
        return root;
    }

    /**
     * 利用中序遍历序列和后序遍历序列构建一颗二叉树
     * 前提：所有结点的值唯一
     *
     * @param in 中序遍历序列
     * @param post 后序遍历序列
     * @return 返回树的根结点
     */
    public static TreeNode mkTreeFromInAndPost(int[] in, int[] post) {
        if (in == null || post == null || in.length != post.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(in.length);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return mkTreeFromInAndPost(0, post, 0, post.length - 1, map);
    }

    private static TreeNode mkTreeFromInAndPost(int si, int[] post, int sp, int ep,
                                                HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(post[ep]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = mkTreeFromInAndPost(si, post, sp, sp + leftLen - 1, map);
        root.right = mkTreeFromInAndPost(idx + 1, post, sp + leftLen, ep - 1, map);
        return root;
    }

    /**
     * 利用中序遍历序列和后序遍历序列构建一颗二叉树
     *
     * @param in 中序遍历序列
     * @param post 后序遍历序列
     * @return 返回树的根结点
     */
    public static TreeNode buildFromInAndPost(int[] in, int[] post) {
        if (in == null || post == null || in.length != post.length) {
            return null;
        }
        return buildFromInAndPost(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    private static TreeNode buildFromInAndPost(int[] in, int startIn, int endIn,
                                               int[] post, int startPost, int endPost) {
        if (startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(post[endPost]);
        // 中序遍历序列根结点索引
        int idx = startIn;
        while (idx <= endIn && in[idx] != root.val) {
            idx++;
        }

        // 左子树序列长度
        int llen = idx - startIn;
        // 左右子树序列中点（右子树序列起始点）
        int mpost = startPost + llen;
        root.left = buildFromInAndPost(in, startIn, idx - 1, post, startPost, mpost - 1);
        root.right = buildFromInAndPost(in, idx + 1, endIn, post, mpost, endPost - 1);
        return root;
    }
}