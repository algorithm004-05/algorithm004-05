/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  let index = wordList.indexOf(beginWord)
  if (index !== -1) {
    wordList.splice(index, 1)
  }
  if (!wordList.length) return 0
  let queue = [beginWord]
  let res = 1
  while (queue.length) {
    let len = queue.length
    for (let i = 0; i < len; i++) {
      let str = queue.shift()
      if (str === endWord) return res
      for (let j = 0; j < wordList.length; j++) {
        if (diff(str, wordList[j])) {
          queue.push(wordList.splice(j, 1)[0])
        }
      }
    }
    res++
  }
  return 0
  function diff(str1, str2) {
    if (str1.length !== str2.length) return false
    let res = 0
    for (let i = 0; i < str1.length; i++) {
      if (str1[i] !== str2[i]) {
        res++
      }
      if (res > 1) return false
    }
    return true
  }
};
var ladderLength = function (beginWord, endWord, wordList) {
  let index = wordList.indexOf(beginWord)
  if (index !== -1) {
    wordList.splice(index, 1)
  }
  index = wordList.indexOf(endWord)
  if (index !== -1) {
    wordList.splice(index, 1)
  } else {
    return 0
  }
  if (!wordList.length) return 0
  let begin = [beginWord]
  let end = [endWord]
  let res = 1
  while (begin.length && end.length) {
    let arr = []
    for (let i = 0; i < begin.length; i++) {
      for (let k = 0; k < wordList.length; k++) {
        if (diff(wordList[k], begin[i])) {
          if (end.includes(wordList[k])) {
            return res + 1
          }
          arr.push(wordList[k])
        }
      }
    }
    let temp = end
    end = arr
    begin = temp
    res++
  }
  return 0
  function diff(str1, str2) {
    if (str1.length !== str2.length) return false
    let res = 0
    for (let i = 0; i < str1.length; i++) {
      if (str1[i] !== str2[i]) {
        res++
      }
      if (res > 1) return false
    }
    return true
  }
};
// @lc code=end

