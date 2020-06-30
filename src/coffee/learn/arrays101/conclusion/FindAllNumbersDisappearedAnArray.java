package coffee.learn.arrays101.conclusion;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   FindAllNumbersDisappearedAnArray.java
 * @Time    :   2020/05/19 23:11:16
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindAllNumbersDisappearedAnArray {
    /**
     * The basic idea is that we iterate through the input array and
     * mark elements as negative using nums[nums[i]-1] = -nums[nums[i]-1].
     * In this way all the numbers that we have seen will be marked as
     * negative. In the second iteration, if a value is not marked as
     * negative, it implies we have never seen that index before, so just
     * add it to the return list.
     *
     * @param nums all numbers
     * @return disappeared numbers
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}