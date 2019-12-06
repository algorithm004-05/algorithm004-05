package lsn19_high_dp;

/**
 * 121. 买卖股票的最佳时机
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
/***
 *
 * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]) dp[i][1][1] =
 * max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) = max(dp[i-1][1][1],
 * -prices[i]) 解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。
 * 
 * 现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。 可以进行进一步化简去掉所有 k： dp[i][0] =
 * max(dp[i-1][0], dp[i-1][1] + prices[i]) dp[i][1] = max(dp[i-1][1],
 * -prices[i])
 *
 * 
 */
/**
 * 参考：
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 *
 */
public class LeetCode_Stock1_121_555 {

	public static void main(String[] args) {
		LeetCode_Stock1_121_555 leetcode = new LeetCode_Stock1_121_555();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(leetcode.maxProfit1(prices));
		System.out.println(leetcode.maxProfit2(prices));
		System.out.println(leetcode.maxProfit3(prices));
	}

	/**
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) dp[i][k][1] =
	 * max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 */

	public int maxProfit1(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int k = 1;
		int[][][] dp = new int[n][k + 1][2];
		dp[0][k][0] = 0;
		dp[0][k][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
			dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
		}
		return dp[n - 1][k][0];
	}

	public int maxProfit1_1(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[][][] dp = new int[n][2][2];
		dp[0][1][0] = 0;
		dp[0][1][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
			dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
		}
		return dp[n - 1][1][0];
	}

	public int maxProfit2(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			if (i - 1 == -1) {
				dp[i][0] = 0;
				// 解释：
				// dp[i][0]
				// = max(dp[-1][0], dp[-1][1] + prices[i])
				// = max(0, -infinity + prices[i]) = 0
				dp[i][1] = -prices[i];
				// 解释：
				// dp[i][1]
				// = max(dp[-1][1], dp[-1][0] - prices[i])
				// = max(-infinity, 0 - prices[i])
				// = -prices[i]
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[n - 1][0];
	}

	public int maxProfit2_1(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[n - 1][0];
	}

	public int maxProfit3(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];
		for (int i = 1; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}

}
