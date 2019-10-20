/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let i = digits.length - 1;
    while (i >= 0) {
        console.log(i)
        if (digits[i] != 9) {
            digits[i] += 1
            break
        } else {
            digits[i] = 0
            if (i == 0) {
                digits.unshift(1)
            }
        }
        i--
    }
    return digits
};