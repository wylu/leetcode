package coffee.learn.binarytree.exercise;

import coffee.common.Node;

/**
 * @File    :   PopulateNextRightPointerInEachNodeII.java
 * @Time    :   2020/04/19 16:46:51
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PopulateNextRightPointerInEachNodeII {
    public Node connect(Node root) {
        Node nextHeadDummy = new Node(0);
        Node nextLevelCur = nextHeadDummy;
        Node levelStart = root;
        while (levelStart != null) {
            Node cur = levelStart;
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
            levelStart = nextHeadDummy.next;
            nextHeadDummy.next = null;
            nextLevelCur = nextHeadDummy;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 7};
        int[] in = new int[]{4, 2, 5, 1, 3, 7};
//        int[] pre = new int[]{1, 2, 4, 7, 5, 3, 6, 8};
//        int[] in = new int[]{7, 4, 2, 5, 1, 3, 6, 8};
        Node tree = Node.mkTreeFromPreAndIn(pre, in);
        PopulateNextRightPointerInEachNodeII populate = new PopulateNextRightPointerInEachNodeII();
        populate.connect(tree);
        PopulateNextRightPointerInEachNode.prt(tree);
    }
}