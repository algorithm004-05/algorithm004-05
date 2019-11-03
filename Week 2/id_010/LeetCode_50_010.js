/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    let r
    if(n == 0) return 1
    if(n === 1) return x
    if(n<0) return myPow(1/x, -n)
    
    let half = ~~(n/2)
    r = myPow(x,half)
    return n%2 === 0? r*r : r*r*x
};