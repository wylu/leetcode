package learn.arrays101.introduction;

/**
 * @File    :   MaxConsecutiveOnes.java
 * @Time    :   2020/05/18 17:11:09
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, cnt = 0;
        for (int num: nums) {
            if (num == 0) {
               res = Math.max(res, cnt);
               cnt = 0;
            } else {
                cnt++;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes ones = new MaxConsecutiveOnes();
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{0, 0, 0}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1, 1, 1}));
        System.out.println(ones.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}