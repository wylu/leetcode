package coffee.learn.arrayandstring.conclusion;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   PascalTriangleII.java
 * @Time    :   2020/05/24 11:08:13
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int num: calRow(rowIndex)) {
            res.add(num);
        }
        return res;
    }

    private int[] calRow(int rowIndex) {
        if (rowIndex == 0) return new int[]{1};
        int[] preRow = calRow(rowIndex - 1);
        int[] curRow = new int[rowIndex + 1];
        curRow[0] = curRow[rowIndex] = 1;
        for (int i = 1; i < rowIndex; i++) {
            curRow[i] = preRow[i - 1] + preRow[i];
        }
        return curRow;
    }
}