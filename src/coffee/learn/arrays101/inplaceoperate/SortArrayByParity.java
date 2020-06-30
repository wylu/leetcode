package coffee.learn.arrays101.inplaceoperate;

import java.util.Arrays;

/**
 * @File    :   SortArrayByParity.java
 * @Time    :   2020/05/19 22:20:51
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) i++;
            while (i < j && A[j] % 2 != 0) j--;
            int tmp = A[i];
            A[i++] = A[j];
            A[j--] = tmp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 4};
        SortArrayByParity parity = new SortArrayByParity();
        parity.sortArrayByParity(A);
        System.out.println(Arrays.toString(A));
    }
}