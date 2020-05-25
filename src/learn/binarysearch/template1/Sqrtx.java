package learn.binarysearch.template1;

/**
 * @File    :   Sqrtx.java
 * @Time    :   2020/05/25 22:26:33
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1, right = x;
        while (left <= right) {
            // prevent integer overflow
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}