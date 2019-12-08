/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.2 22:35
 * @Description:
 */
public class A122 {

    public static void main(String[] args) {
        A122 a122 = new A122();
        int[] prices = new int[]{1, 2, 1, 5};
        System.out.println(a122.maxProfit(prices));
    }

    /**
     * 只要后一天能比前一天高，那么就应该记录下来
     * 时间 O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }
}
