package learn.recursion.memoization;

import java.util.HashMap;

/**
 * @File    :   FibonacciNumber.java
 * @Time    :   2020/05/08 22:05:44
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FibonacciNumber {
    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int fib(int N) {
        if (cache.containsKey(N)) return cache.get(N);
        int res = N < 2 ? N : fib(N - 1) + fib(N - 2);
        cache.put(N, res);
        return res;
    }
}