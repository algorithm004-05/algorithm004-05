/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    for(var i = digits.length-1; i>=0; --i){
        digits[i]++
        digits[i]%=10
        if(digits[i]!==0){
            return digits
        }
    }
    digits = [1,...digits]
    return digits
};