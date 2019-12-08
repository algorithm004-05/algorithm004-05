/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
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
var preorder = function (root) {
  let res = []
  function helper(root) {
    if (!root) return
    res.push(root.val)
    root.children.map(i => {
      helper(i)
    })
  }
  helper(root)
  return res
};
var preorder = function (root) {
  let res = []
  let stack = []
  stack.unshift(root)
  while (stack.length && root) {
    root = stack.pop()
    res.push(root.val)
    for (let i = root.children.length - 1; i >= 0; i--) {
      stack.push(root.children[i])
    }
  }
  return res
};
// @lc code=end

