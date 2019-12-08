/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let profit = 0
    if(prices.length <=1) return 0
    for(let i = 0;i<prices.length -1;++i){
        const temp = prices[i+1] -prices[i]
        if(temp > 0) profit+=temp
    }
    
    return profit
};