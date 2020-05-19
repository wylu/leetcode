package learn.arrays101.inplaceoperate;

import java.util.Arrays;

/**
 * @File    :   MoveZeroes.java
 * @Time    :   2020/05/19 22:03:47
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{1, 1, 1};
        MoveZeroes zeroes = new MoveZeroes();
        zeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}