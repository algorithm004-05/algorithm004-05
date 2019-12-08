/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    console.log((n&(n-1)))
    return (n>0) && (n&(n-1))===0;
};