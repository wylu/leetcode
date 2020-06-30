package coffee.learn.binarysearch.practices;

import java.util.HashSet;
import java.util.Set;

/**
 * @File    :   IntersectionOfTwoArrays.java
 * @Time    :   2020/05/30 11:49:19
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersects = new HashSet<>();
        for (int num: nums1) set.add(num);
        for (int num: nums2) if (set.contains(num)) intersects.add(num);

        int[] res = new int[intersects.size()];
        int i = 0;
        for (int num: intersects) res[i++] = num;
        return res;
    }
}