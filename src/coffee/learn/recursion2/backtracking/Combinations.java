package coffee.learn.recursion2.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   Combinations.java
 * @Time    :   2020/05/13 21:13:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, ArrayList<Integer> comb,
                         int c, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = c; i <= n; i++) {
            comb.add(i);
            combine(res, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}