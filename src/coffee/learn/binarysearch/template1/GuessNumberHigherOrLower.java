package coffee.learn.binarysearch.template1;

/**
 * @File    :   GuessNumberHigherOrLower.java
 * @Time    :   2020/05/25 22:50:41
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */

class GuessGame {
    private int target;
    public GuessGame(int target) {
        this.target = target;
    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    public int guess(int num) {
        return Integer.compare(target, num);
    }
}


public class GuessNumberHigherOrLower extends GuessGame {
    public GuessNumberHigherOrLower(int target) {
        super(target);
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res > 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}