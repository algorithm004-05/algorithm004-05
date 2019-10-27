/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class LeetCode_50_100 {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        //prepare data
        double half = fastPow(x, n/2);
        //conqur subproblem
        if (n % 2 == 1) {
            return half * half * x;
        }
        return half * half;
    }
}