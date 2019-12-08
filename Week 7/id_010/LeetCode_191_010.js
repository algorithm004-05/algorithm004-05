/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    var numOfZero = 0;
    while(n){
        numOfZero += n%2;
        n >>=1;
    }
    return numOfZero;
};