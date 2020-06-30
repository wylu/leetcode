package coffee.learn.binarysearch.conclusion;

/**
 * @File    :   ValidPerfectSquare.java
 * @Time    :   2020/05/30 10:43:00
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long square = mid * mid;
            if (square == num) return true;
            else if (square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare valider = new ValidPerfectSquare();
        System.out.println(valider.isPerfectSquare(Integer.MAX_VALUE));
    }
}