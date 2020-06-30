package coffee.learn.binarysearch.template3;

import java.util.Arrays;

/**
 * @File    :   SearchForARange.java
 * @Time    :   2020/05/29 09:15:58
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] notFound = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return notFound;

        int leftmost = getIndex(nums, target, true);
        if (leftmost == nums.length || nums[leftmost] != target) {
            return notFound;
        }

        int rightmost = getIndex(nums, target, false) - 1;
        return new int[]{leftmost, rightmost};
    }

    private int getIndex(int[] nums, int target, boolean start) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (start && nums[mid] >= target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{2, 2};
        SearchForARange searchForARange = new SearchForARange();
        int[] res = searchForARange.searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}