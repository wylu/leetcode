package learn.binarysearch.template1;

/**
 * @File    :   SearchInRotatedSortedArray.java
 * @Time    :   2020/05/25 23:10:23
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SearchInRotatedSortedArray {
    /**
     * Let's say nums looks like this:
     * [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
     *
     * Because it's not fully sorted, we can't do normal binary search. But here
     * comes the trick:
     *
     * If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
     * [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
     *
     * If target is let's say 7, then we adjust nums to this:
     * [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
     *
     * And then we can simply do ordinary binary search. Of course we don't actually
     * adjust the whole array but instead adjust only on the fly only the elements
     * we look at. And the adjustment is done by comparing both the target and the
     * actual element against nums[0].
     *
     * @param nums rotate array
     * @param target the element to search
     * @return the index of target
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                // on the same side
                tmp = nums[mid];
            } else {
                tmp = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (tmp == target) return mid;
            else if (tmp < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}