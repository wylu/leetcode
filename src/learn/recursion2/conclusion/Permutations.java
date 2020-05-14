package learn.recursion2.conclusion;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   Permutations.java
 * @Time    :   2020/05/14 23:01:11
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        permute(res, 0, nums);
        return res;
    }

    private void permute(List<List<Integer>> res, int cur, int[] nums) {
        if (cur == nums.length) {
            List<Integer> seq = new ArrayList<>();
            for (int num: nums) seq.add(num);
            res.add(seq);
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            swap(nums, cur, i);
            permute(res, cur + 1, nums);
            swap(nums, cur, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}