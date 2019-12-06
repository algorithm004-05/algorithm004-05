/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let total = 0;
    var getTotal = function(cur) {
        if(cur<0) return;
       if(cur === 0){
           ++total;
           return;
       }
       getTotal(cur-1);
        getTotal(cur-2);
   }
    getTotal(n);
    return total
};