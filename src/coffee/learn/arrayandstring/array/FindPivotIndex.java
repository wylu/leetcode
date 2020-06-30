package coffee.learn.arrayandstring.array;

/**
 * @File    :   FindPivotIndex.java
 * @Time    :   2020/05/20 20:36:00
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int e: nums) sum += e;

        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (cur == sum - cur - nums[i]) return i;
            cur += nums[i];
        }
        return -1;
    }
}