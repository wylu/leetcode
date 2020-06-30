package coffee.learn.binarysearch.conclusion;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = myPow(x, n / 2);
        if (n % 2 == 0) return res * res;
        return n < 0 ? res * res * (1 / x) : res * res * x;
    }
}