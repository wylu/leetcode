package learn.arrays101.inplaceoperate;

import java.util.Arrays;

/**
 * @File    :   SquaresOfASortedArray.java
 * @Time    :   2020/05/19 22:27:21
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}