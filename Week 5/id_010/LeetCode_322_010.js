/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {    
    let values = new Array(amount+1).fill(Infinity)
    values[0] = 0
    for(let val = 1; val<=amount; ++val){
        for(let c = 0; c<coins.length;++c){
            if(coins[c]<=val){
                values[val] = Math.min(values[val],values[val-coins[c]]+1)
            }
        }
    }
    
    return values[amount] > amount ? -1: values[amount]
};