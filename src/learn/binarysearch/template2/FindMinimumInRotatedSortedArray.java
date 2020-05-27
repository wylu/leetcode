package learn.binarysearch.template2;

/**
 * @File    :   FindMinimumInRotatedSortedArray.java
 * @Time    :   2020/05/27 22:49:47
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[right] >= nums[left]) return nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}