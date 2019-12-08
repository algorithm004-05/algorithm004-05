//122. 买卖股票的最佳时机 II

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)
            return 0;
        int maxDev=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxDev+=prices[i]-prices[i-1];
            }
        }
        return maxDev;
    }
}