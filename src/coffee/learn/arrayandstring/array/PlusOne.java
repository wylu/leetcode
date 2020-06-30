package coffee.learn.arrayandstring.array;

import java.util.Arrays;

/**
 * @File    :   PlusOne.java
 * @Time    :   2020/05/20 21:18:25
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean needCarry = true;
        for (int e: digits) {
            if (e != 9) {
                needCarry = false;
                break;
            }
        }

        int carry = 1, len = digits.length;
        int[] res = needCarry ? new int[len + 1] : new int[len];
        for (int i = digits.length - 1, j = needCarry ? len : len - 1; i >= 0; i--, j--) {
            res[j] = digits[i] + carry;
            carry = res[j] / 10;
            res[j] %= 10;
        }
        if (needCarry) res[0] = carry;
        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}