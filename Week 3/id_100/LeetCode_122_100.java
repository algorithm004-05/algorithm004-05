/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class LeetCode_122_100 {

    /**
     * 如若后一天小于这一天时是最合适的抛出机会
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

}