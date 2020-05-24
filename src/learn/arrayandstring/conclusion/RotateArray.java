package learn.arrayandstring.conclusion;

import java.util.Arrays;

/**
 * @File    :   RotateArray.java
 * @Time    :   2020/05/24 10:57:58
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}