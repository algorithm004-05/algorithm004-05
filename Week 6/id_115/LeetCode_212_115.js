/*
 * @lc app=leetcode.cn id=212 lang=javascript
 *
 * [212] 单词搜索 II
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
  let res = []
  let trie = {}
  for (let i = 0; i < words.length; i++) {
    t = trie
    for (let j = 0; j < words[i].length; j++) {
      if (!t[words[i][j]]) {
        t[words[i][j]] = {}
      }
      t = t[words[i][j]]
    }
    t.end = true
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      dfs(i, j, trie, '')
    }
  }
  function dfs(i, j, t, str) {
    let cur = board[i][j]
    // console.log(cur,t[cur])
    if (!t[cur]) return
    t = t[cur]
    // console.log(cur,t.end)
    if (t.end) {
      res.push(str + cur)
      t.end = 0
      return
    }
    board[i][j] = '#'
    if (i + 1 < board.length && board[i + 1][j] !== '#') {
      dfs(i + 1, j, t, str + cur)
    }
    if (i - 1 >= 0 && board[i - 1][j] !== '#') {
      dfs(i - 1, j, t, str + cur)
    }
    if (j + 1 < board[i].length && board[i][j + 1] !== '#') {
      dfs(i, j + 1, t, str + cur)
    }
    if (j - 1 >= 0 && board[i][j - 1] !== '#') {
      dfs(i, j - 1, t, str + cur)
    }
    board[i][j] = cur
  }
  return res
};
console.log(findWords([["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]],
  ["oath", "pea", "eat", "rain"]))

var findWords = function (board, words) {

  function Trie() {
    this.next = {}
    this.isWord = false
  }
  Trie.prototype.insert = function (word) {
    let cur = this
    for (let i = 0; i < word.length; i++) {
      if (!cur.next.hasOwnProperty(word[i])) {
        cur.next[word[i]] = new Trie
      }
      cur = cur.next[word[i]]
    }
    cur.isWord = true
  }

  Trie.prototype.search = function (word) {
    let cur = this
    for (let i = 0; i < word.length; i++) {
      if (cur.next.hasOwnProperty(word[i])) {
        cur = cur.next[word[i]]
      } else {
        return false
      }
    }
    if (cur.isWord) {
      cur.isWord = false
      return true
    }
  }
  Trie.prototype.startWith = function (word) {
    let cur = this
    for (let i = 0; i < word.length; i++) {
      if (cur.next.hasOwnProperty(word[i])) {
        cur = cur.next[word[i]]
      } else {
        return false
      }
    }
    return true
  }
  let trie = new Trie()
  for (let item of words) {
    trie.insert(item)
  }
  let res = []
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      dfs(i, j, board[i][j], res)
    }
  }
  function dfs(x, y, str, res) {
    if (!trie.startWith(str)) return
    if (trie.search(str)) {
      res.push(str)
    }

    let cur = board[x][y]
    board[x][y] = '#'
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    for (let i = 0; i < 4; i++) {
      let x_ = x + dx[i]
      let y_ = y + dy[i]
      if (x_ >= 0 && x_ < board.length && y_ >= 0 && y_ < board[x_].length && board[x_][y_] != '#') {
        dfs(x_, y_, str + board[x_][y_], res)
      }
    }
    board[x][y] = cur
  }

  return res
};
// @lc code=end

