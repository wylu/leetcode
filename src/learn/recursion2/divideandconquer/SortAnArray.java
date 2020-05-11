package learn.recursion2.divideandconquer;

/**
 * @File    :   SortAnArray.java
 * @Time    :   2020/05/11 22:07:31
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int[] tmp = new int[nums.length];
        for (int size = 1; size < nums.length; size *= 2) {
            int left, mid, right;
            for (left = 0; left + size < nums.length; left = right + 1) {
                mid = left + size - 1;
                right = Math.min(mid + size, nums.length - 1);
                merge(nums, left, mid, right, tmp);
            }
        }
        return nums;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) tmp[t++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
        while (i <= mid) tmp[t++] = nums[i++];
        while (j <= right) tmp[t++] = nums[j++];
        t = 0;
        while (left <= right) nums[left++]=tmp[t++];
    }
}