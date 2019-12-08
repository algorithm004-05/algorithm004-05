/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function (root) {
  let res = []
  function helper(root) {
    if (!root) return
    res.push(root.val)
    if (root.left) {
      helper(root.left)
    }
    if (root.right) {
      helper(root.right)
    }
  }
  helper(root)
  return res
};
var preorderTraversal = function (root) {
  let res = []
  let stack = []
  while (root || stack.length) {
    if (root) {
      stack.push(root)
      res.push(root.val)
      root = root.left
    }
    !root && (root = stack.pop().right)
  }
  return res
};
// @lc code=end

