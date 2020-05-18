package learn.arrays101.searchitems;

/**
 * @File    :   ValidMountainArray.java
 * @Time    :   2020/05/18 23:34:06
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0, j = A.length - 1;
        while (i + 1 < A.length && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < A.length - 1;
    }
}