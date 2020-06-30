package coffee.learn.binarysearch.practices;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @File    :   IntersectionOfTwoArraysII.java
 * @Time    :   2020/05/30 22:52:07
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> sects = new ArrayList<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums2) {
            if (map.containsKey(num)) {
                sects.add(num);
                int cnt = map.get(num) - 1;
                if (cnt == 0) map.remove(num);
                else map.put(num, cnt);
            }
        }

        int[] res = new int[sects.size()];
        for (int i = 0; i < sects.size(); i++) {
            res[i] = sects.get(i);
        }
        return res;
    }
}