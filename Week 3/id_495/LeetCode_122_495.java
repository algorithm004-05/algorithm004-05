class LeetCode_122_495 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {1,2,3,4,5}));
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;

        //记录差值
        int Dvalue = 0;
        for(int i = 0; i < prices.length - 1; i++){
            Dvalue = prices[i+1] - prices[i];
            if (Dvalue > 0){
                ans += Dvalue;
            }
        }

        return ans;
    }
}
