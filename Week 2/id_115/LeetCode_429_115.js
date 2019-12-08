/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  let arr = []
  function helper(n, root) {
    if (!root) return
    if (arr[n] === undefined) {
      arr[n] = []
    }
    arr[n].push(root.val)
    ++n
    if (root.children.length) {
      root.children.map(i => {
        helper(n, i)
      })
    }

  }
  helper(0, root)
  return arr
};
var levelOrder = function (root) {
  if (!root) return []
  let res = []
  let stack = [root]
  while (stack.length) {
    let arr = []
    let n = stack.length
    for (let i = 0; i < n; i++) {
      let cur = stack.shift()
      arr.push(cur.val)
      for (let j = 0; j < cur.children.length; j++) {
        cur.children[j] && stack.push(cur.children[j])
      }
    }
    res.push(arr)
  }
  return res
};
// @lc code=end

