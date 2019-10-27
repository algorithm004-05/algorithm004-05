/**
 * @param {number[]} digits
 * @return {number[]}
 */
// var plusOne = function (digits) {
//   return ((Number(digits.join('')) + 1) + '').split('')
// };


var plusOne = function (digits) {
  for(let i = digits.length - 1; i >= 0 ; i--) {
    if(digits[i] < 9) {
      digits[i] = digits[i] + 1
      return digits
    } else {
      digits[i] = 0
    }
  }
  if(digits[0] === 0) {
    digits.unshift(1)
  }
  return digits
};
