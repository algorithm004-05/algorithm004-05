/**
 * created by lchen on 2019/10/26
 */
public class LeetCode_50_535 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.myPow(2, -1));
    }

}

class Solution3 {
    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N =  -N;
        }
        return recursion(x, N);
    }

    public double recursion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double recursion = recursion(x, n / 2);
        if (n % 2 == 0) {
            return recursion * recursion;
        } else {
            return recursion * recursion * x;
        }
    }
}