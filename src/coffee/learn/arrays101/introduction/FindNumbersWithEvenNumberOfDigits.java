package coffee.learn.arrays101.introduction;

/**
 * @File    :   FindNumbersWithEvenNumberOfDigits.java
 * @Time    :   2020/05/18 19:13:00
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num: nums) {
            if (check(num)) res++;
        }
        return res;
    }

    private boolean check(int num) {
        if (num == 0) return false;
        int cnt = 0;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        return cnt % 2 == 0;
    }

    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits digits = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(digits.findNumbers(new int[]{}));
        System.out.println(digits.findNumbers(new int[]{0}));
        System.out.println(digits.findNumbers(new int[]{1}));
        System.out.println(digits.findNumbers(new int[]{0, 1}));
        System.out.println(digits.findNumbers(new int[]{0, 1, 10, 101, 1010}));
    }
}