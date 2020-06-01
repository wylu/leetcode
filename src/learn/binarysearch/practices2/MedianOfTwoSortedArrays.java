package learn.binarysearch.practices2;

/**
 * @File    :   MedianOfTwoSortedArrays.java
 * @Time    :   2020/06/01 23:02:47
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length, y = nums2.length;
        int low = 0, high = x, halfLen = (x + y + 1) / 2;
        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = halfLen - partX;

            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE : nums1[partX];

            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX <= minRightY) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        // 1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25
        MedianOfTwoSortedArrays mm = new MedianOfTwoSortedArrays();
        System.out.println(mm.findMedianSortedArrays(x, y));
    }
}