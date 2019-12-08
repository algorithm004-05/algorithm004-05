/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function (bills) {
  let five = 0
  let ten = 0
  let i = 0
  while (i < bills.length) {
    if (bills[i] === 5) {
      five++
    } else if (bills[i] === 10) {
      if (!five) return false
      five--
      ten++
    } else {
      if (ten && five) {
        ten--
        five--
      } else if (five >= 3) {
        five -= 3
      } else {
        return false
      }
    }
    i++
  }
  return true
};
// @lc code=end

