/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    for(var i = digits.length - 1; i >= 0; i--) {
        digits[i] = (digits[i] + 1) % 10;
        if (digits[i]) return digits;
    }
    digits.unshift(1);
    return digits;
};