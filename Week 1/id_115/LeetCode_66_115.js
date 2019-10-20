/*
 *
 * [66] 加一
 */

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    digits[i]++
    digits[i] = digits[i] % 10
    if (digits[i]) {
      return digits
    }
  }
  return [1].concat(digits)
};

/**
 * 耗时：68ms 击败83.87%
 * 内存：33.7mb
 * 时间复杂度O（n）
 */
// ------------------------------------------
