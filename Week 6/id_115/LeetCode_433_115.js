/*
 * @lc app=leetcode.cn id=433 lang=javascript
 *
 * [433] 最小基因变化
 */

// @lc code=start
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function (start, end, bank) {
  if (!bank.includes(end)) return -1
  let res = 0
  let begin = [start]
  let over = [end]
  while (begin.length && over.length) {
    let len = begin.length
    for (let i = 0; i < len; i++) {
      let cur = begin.shift()
      if (over.includes(cur)) {
        return res
      }
      for (let j = 0; j < bank.length; j++) {
        if (diff(cur, bank[j])) {
          begin.push(bank[j])
        }
      }
    }
    if (begin.length >= over.length) {
      [begin, over] = [over, begin]
    }
    res++
  }
  return -1
  function diff(str1, str2) {
    if (str1.length !== str2.length) return false
    let res = 0
    for (let i = 0; i < str1.length; i++) {
      if (str1[i] !== str2[i]) {
        res++
      }
    }
    return res == 1
  }
};
// @lc code=end

