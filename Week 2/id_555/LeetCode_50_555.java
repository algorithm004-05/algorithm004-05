package lsn08.divide;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 
 * 50. Pow(x, n)
 *
 */
public class LeetCode_50_555 {

	public static void main(String[] args) {
		LeetCode_50_555 leetcode = new LeetCode_50_555();
		double res = leetcode.myPow2(2, -2);
		System.out.println(res);
	}

	public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

	
	public double fastPow(double x, long n) {
		if (n == 0) {
			return 1;
		}
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		return fastPow(x, N);
	}

}
