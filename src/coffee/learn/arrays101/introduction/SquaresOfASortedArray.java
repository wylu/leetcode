package coffee.learn.arrays101.introduction;

import java.util.Arrays;

/**
 * @File    :   SquaresOfASortedArray.java
 * @Time    :   2020/05/18 19:37:18
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray squares = new SquaresOfASortedArray();
        int[] res = squares.sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(Arrays.toString(res));
    }
}