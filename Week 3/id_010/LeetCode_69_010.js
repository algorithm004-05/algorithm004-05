/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let r = x
    while (r*r > x){
        r = ((r+x/r)/2) | 0
    }
    
    return r
};