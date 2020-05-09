package learn.recursion.conclusion;

/**
 * @File    :   KthSymbolInGrammar.java
 * @Time    :   2020/05/09 22:29:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class KthSymbolInGrammar {
    /**
     * The whole structure can be viewed a binary tree, when a node is 0,
     * their two children nodes are 0 and 1, similarly, when a node is 1,
     * two children nodes are 1 and 0.
     *
     * We can know whether the position of K is a left node or a right node
     * by dividing 2. If K is even, current node is right child, and its parent
     * is the (K/2)th node in previous row; else if K is odd, current node is
     * left child and its parent is the ((K+1)/2)th node in previous row.
     *
     * @param N N will be an integer in the range [1, 30]
     * @param K K will be an integer in the range [1, 2^(N-1)]
     * @return K-th indexed symbol in row N
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0) return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
        return kthGrammar(N - 1, (K + 1) / 2) == 0 ? 0 : 1;
    }
}