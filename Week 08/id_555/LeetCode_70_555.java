package lsn19_high_dp;

/**
 * 70. 爬楼梯
 * 
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LeetCode_70_555 {

	public static void main(String[] args) {
		LeetCode_70_555 leetcode = new LeetCode_70_555();
		int n = 5;
		// n = 4
		// 1、1、1、1
		// 1、2、1；1、1、2；2、1、1；
		// 1、3；3、1
		// -------------
		// n =5
		// 1 1 1 1 1;
		// 1 1 1 2;1 1 2 1;1 2 1 1;2 1 1 1;
		// 1 1 3;1 3 1;3 1 1;
		// 2 3 ;3 2
		System.out.println(leetcode.climbStairs2(n));
	}

	/**
	 * 每次1或2个台阶
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}

	/**
	 * 每次1或2或3个台阶
	 */
	public int climbStairs2(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for (int i = 3; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n - 1];
	}

}
