package coffee.learn.arrays101.insertitems;

import java.util.Arrays;

/**
 * @File    :   DuplicateZeros.java
 * @Time    :   2020/05/18 21:55:53
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int cnt = 0;
        for (int e: arr) {
            if (e == 0) cnt++;
        }

        int len = arr.length + cnt;
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros zeros = new DuplicateZeros();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        zeros.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1, 2, 3};
        zeros.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}