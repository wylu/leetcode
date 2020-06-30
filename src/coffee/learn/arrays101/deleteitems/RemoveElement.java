package coffee.learn.arrays101.deleteitems;

import java.util.Arrays;

/**
 * @File    :   RemoveElement.java
 * @Time    :   2020/05/18 22:18:28
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement remover = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        int len = remover.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums) + " " + len);

        nums = new int[]{3, 2, 3, 2, 3};
        len = remover.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums) + " " + len);

        nums = new int[]{3, 3, 3};
        len = remover.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums) + " " + len);

        nums = new int[]{2, 4, 4, 4, 0};
        len = remover.removeElement(nums, 4);
        System.out.println(Arrays.toString(nums) + " " + len);
    }
}