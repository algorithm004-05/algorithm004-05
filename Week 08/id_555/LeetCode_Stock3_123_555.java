package lsn19_high_dp;

/**
 * 123. 买卖股票的最佳时机 III
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 */
public class LeetCode_Stock3_123_555 {

	public static void main(String[] args) {
		LeetCode_Stock3_123_555 leetcode = new LeetCode_Stock3_123_555();
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
//		int[] prices = { 1, 2, 3, 4, 5 };
		System.out.println(leetcode.maxProfit(prices));
		System.out.println(leetcode.maxProfit2(prices));
		System.out.println(leetcode.maxProfit3(prices));
	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int max_k = 2;
		int[][][] dp = new int[n][max_k + 1][2];

		for (int i = 1; i < n; i++) {
			for (int k = max_k; k >= 1; k--) {
				dp[0][k][0] = 0;
				dp[0][k][1] = -prices[0];

				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][max_k][0];
	}

	public int maxProfit2(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[][][] dp = new int[n][3][2];
		dp[0][2][0] = 0;
		dp[0][1][0] = 0;
		dp[0][1][1] = -prices[0];
		dp[0][2][1] = -prices[0];

		for (int i = 1; i < n; i++) {
			dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
			dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
			dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
			dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
		}
		return dp[n - 1][2][0];
	}

	public int maxProfit3(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int dp_i10 = 0;
		int dp_i20 = 0;
//		int dp_i11 = Integer.MIN_VALUE;
//		int dp_i21 = Integer.MIN_VALUE;
		int dp_i11 = -prices[0];
		int dp_i21 = -prices[0];
		for (int price : prices) {
			dp_i20 = Math.max(dp_i20, dp_i21 + price);
			dp_i21 = Math.max(dp_i21, dp_i10 - price);
			dp_i10 = Math.max(dp_i10, dp_i11 + price);
			dp_i11 = Math.max(dp_i11, -price);
		}
		return dp_i20;
	}

}
