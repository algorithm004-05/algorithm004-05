/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
  s = s.split('').sort()
  t = t.split("").sort()
  let n = Math.max(s.length, t.length)
  for (let i = 0; i < n; i++) {
    if (t[i] !== s[i]) {
      return false
    }
  }
  return true
};
var isAnagram = function (s, t) {
  s = s.split('').sort().join("")
  t = t.split("").sort().join("")
  return s === t
};
var isAnagram = function (s, t) {
  if (s.length !== t.length) return false
  let arr = new Array(26)
  for (let i = 0; i < 26; i++) {
    arr[i] = 0
  }
  for (let i = 0; i < s.length; i++) {
    arr[s[i].charCodeAt() - 'a'.charCodeAt()]++
  }
  for (let i = 0; i < t.length; i++) {
    arr[t[i].charCodeAt() - 'a'.charCodeAt()]--
    if (arr[t[i].charCodeAt() - 'a'.charCodeAt()] < 0) {
      return false
    }
  }
  return true
};
isAnagram("nagaram","anagram")
// @lc code=end

