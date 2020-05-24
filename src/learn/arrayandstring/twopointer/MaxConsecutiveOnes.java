package learn.arrayandstring.twopointer;

/**
 * @File    :   MaxConsecutiveOnes.java
 * @Time    :   2020/05/24 10:22:59
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, cnt = 0;
        for (int num: nums) {
            if (num == 0) {
                res = Math.max(res, cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }
}