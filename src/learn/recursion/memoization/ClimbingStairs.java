package learn.recursion.memoization;

import java.util.HashMap;

/**
 * @File    :   ClimbingStairs.java
 * @Time    :   2020/05/08 22:17:26
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ClimbingStairs {
    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int res = n < 3 ? n : climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, res);
        return res;
    }
}