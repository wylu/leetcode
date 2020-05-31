package learn.binarysearch.practices;

import java.util.HashMap;

/**
 * @File    :   TwoSumII.java
 * @Time    :   2020/05/31 23:05:47
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            if (map.containsKey(val)) return new int[]{map.get(val) + 1, i + 1};
            map.put(numbers[i], i);
        }
        return null;
    }
}