/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
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
 * @return {number[]}
 */
var postorder = function (root) {
  let res = []
  function helper(root) {
    if (!root) return
    if (!root.children) {
      res.push(root.val)
    } else {
      root.children.map(i => {
        helper(i)
      })
    }
  }
  helper(root)
  return res
};
var postorder = function (root) {
  let res = []
  let stack = []
  stack.push(root)
  while (stack.length && root) {
    root = stack.pop()
    res.push(root.val)
    root.children.map(i => {
      stack.push(i)
    })
  }
  return res.reverse()
};
// @lc code=end

