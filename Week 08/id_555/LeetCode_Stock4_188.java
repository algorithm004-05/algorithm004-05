package lsn19_high_dp;

public class LeetCode_Stock4_188 {

	public static void main(String[] args) {
		LeetCode_Stock4_188 leetcode = new LeetCode_Stock4_188();
		int[] prices = { 3, 2, 6, 5, 0, 3 };// 输出7
		int k = 2;
		System.out.println(leetcode.maxProfit(k, prices));

	}

	public int maxProfit(int max_k, int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		if (max_k > n / 2)// 超出内存限制
			return maxProfit_k_inf(prices);

		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 1; i < n; i++)
			for (int k = max_k; k >= 1; k--) {
				dp[0][k][0] = 0;
				dp[0][k][1] = -prices[0];

				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		return dp[n - 1][max_k][0];
	}

	int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}

}
