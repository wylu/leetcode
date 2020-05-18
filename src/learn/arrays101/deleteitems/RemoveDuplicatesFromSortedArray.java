package learn.arrays101.deleteitems;

/**
 * @File    :   RemoveDuplicatesFromSortedArray.java
 * @Time    :   2020/05/18 23:07:24
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int behind = 0, front = 1;
        while (front < nums.length) {
            if (nums[front] == nums[behind]) {
                front++;
            } else {
                nums[++behind] = nums[front++];
            }
        }
        return behind + 1;
    }
}