package learn.arrayandstring.twodarray;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   PascalTriangle.java
 * @Time    :   2020/05/20 23:33:59
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;

        List<Integer> level = new ArrayList<>(), preLevel;
        level.add(1);
        res.add(level);

        for (int i = 1; i < numRows; i++) {
            level = new ArrayList<>();
            level.add(1);
            preLevel = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                level.add(preLevel.get(j - 1) + preLevel.get(j));
            }
            level.add(1);
            res.add(level);
        }
        return res;
    }
}