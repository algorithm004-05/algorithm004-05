package lsn19_high_dp;

/**
 * 122. 买卖股票的最佳时机 II
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 */
public class LeetCode_Stock2_122_555 {

	public static void main(String[] args) {

	}

	/**
	 * 
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
            = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
	 *
	 *
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return dp[n - 1][0];
	}

	public int maxProfit2(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];
		for (int i = 1; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		return dp_i_0;
	}

}
