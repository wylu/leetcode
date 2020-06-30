package coffee.learn.arrays101.searchitems;

import java.util.HashSet;

/**
 * @File    :   CheckIfNAndItsDoubleExist.java
 * @Time    :   2020/05/18 23:24:14
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int e: arr) {
            if (e != 0) set.add(e);
            else cnt++;
        }

        for (int e: arr) {
            if (set.contains(e * 2)) return true;
        }
        return cnt > 1;
    }
}