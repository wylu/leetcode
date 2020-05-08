package learn.recursion.complexity;

/**
 * @File    :   PowXN.java
 * @Time    :   2020/05/08 22:42:06
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = myPow(x, n / 2);
        if (n % 2 == 0) return res * res;
        return n < 0 ? res * res * (1 / x) : res * res * x;
    }
}