package coffee.common;

/**
 * @File    :   Node.java
 * @Time    :   2020/04/18 22:38:01
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    /**
     * 利用前序遍历序列和中序遍历序列构建一颗二叉树
     *
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @return 返回树的根结点
     */
    public static Node mkTreeFromPreAndIn(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return mkTreeFromPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static Node mkTreeFromPreAndIn(int[] pre, int startPre, int endPre,
                                           int[] in, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }
        Node root = new Node(pre[startPre]);
        // 中序遍历序列根结点索引
        int idx = startIn;
        while (idx <= endIn && in[idx] != root.val) {
            idx++;
        }

        // 左子树序列长度
        int llen = idx - startIn;
        // 左右子树序列中点（右子树序列起始点）
        int mpre = startPre + 1 + llen;
        root.left = mkTreeFromPreAndIn(pre, startPre + 1, mpre - 1, in, startIn, idx - 1);
        root.right = mkTreeFromPreAndIn(pre, mpre, endPre, in, idx + 1, endIn);
        return root;
    }

    /**
     * 利用中序遍历序列和后序遍历序列构建一颗二叉树
     *
     * @param in 中序遍历序列
     * @param post 后序遍历序列
     * @return 返回树的根结点
     */
    public static Node mkTreeFromInAndPost(int[] in, int[] post) {
        if (in == null || post == null || in.length != post.length) {
            return null;
        }
        return mkTreeFromInAndPost(in, 0, in.length - 1, post, 0, post.length - 1);
    }

    private static Node mkTreeFromInAndPost(int[] in, int startIn, int endIn,
                                            int[] post, int startPost, int endPost) {
        if (startPost > endPost) {
            return null;
        }
        Node root = new Node(post[endPost]);
        // 中序遍历序列根结点索引
        int idx = startIn;
        while (idx <= endIn && in[idx] != root.val) {
            idx++;
        }

        // 左子树序列长度
        int llen = idx - startIn;
        // 左右子树序列中点（右子树序列起始点）
        int mpost = startPost + llen;
        root.left = mkTreeFromInAndPost(in, startIn, idx - 1, post, startPost, mpost - 1);
        root.right = mkTreeFromInAndPost(in, idx + 1, endIn, post, mpost, endPost - 1);
        return root;
    }

    public static void prtTree(Node root) {
        if (root  == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (root.right != null) {
            prtTree(root.right, sb, true, "");
        }
        sb.append(root.val).append("\n");
        if (root.left != null) {
            prtTree(root.left, sb, false, "");
        }
        System.out.println(sb.toString());
    }

    private static void prtTree(Node root, StringBuilder sb, boolean isRight, String indent) {
        if (root.right != null) {
            prtTree(root.right, sb, true, indent + (isRight ? "        " : " |      "));
        }
        sb.append(indent);
        sb.append(isRight ? " /" : " \\");
        sb.append("----- ");
        sb.append(root.val).append("\n");
        if (root.left != null) {
            prtTree(root.left, sb, false, indent + (isRight ? " |      " : "        "));
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println("Case 1: -------------------------------------------");
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Node root = Node.mkTreeFromPreAndIn(pre, in);
        Node.prtTree(root);

        // Case 2
        System.out.println("Case 2: -------------------------------------------");
        in = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20};
        int[] post = new int[] {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 20, 14, 12, 8};
        root = Node.mkTreeFromInAndPost(in, post);
        Node.prtTree(root);
    }
}