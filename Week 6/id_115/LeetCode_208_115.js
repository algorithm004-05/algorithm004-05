/*
 * @lc app=leetcode.cn id=208 lang=javascript
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
var Trie = function () {
  this.next = {}
  this.isWord = true
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
  let cur = this
  for (let i = 0; i < word.length; i++) {
    if (!cur.next.hasOwnProperty(word[i])) {
      cur.next[word[i]] = new Trie()
      cur = cur.next[word[i]]
    } else {
      cur = cur.next[word[i]]
    }
  }
  cur.isWord = true
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
  let cur = this
  for (let i = 0; i < word.length; i++) {
    if (cur.next.hasOwnProperty(word[i])) {
      cur = cur.next[word[i]]
    } else {
      return false
    }
  }
  return cur.isWord
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
  let cur = this
  for (let i = 0; i < prefix.length; i++) {
    if (cur.next.hasOwnProperty(prefix[i])) {
      cur = cur.next[prefix[i]]
    } else {
      return false
    }
  }
  return true
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
// @lc code=end

