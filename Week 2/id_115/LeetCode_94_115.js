/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
var inorderTraversal = function (root) {
  let arr = []
  function helper(root) {
    if (!root) return arr
    if (root.left) {
      helper(root.left)
    }
    arr.push(root.val)
    if (root.right) {
      helper(root.right)
    }
  }
  helper(root)
  return arr
};
var inorderTraversal = function (root) {
  let res = []
  let stack = []
  while (root || stack.length) {
    if (root.left) {
      stack.push(root)
      root = root.left
    } else if (!root.left && !root.right) {
      res.push(root.val)
      root = stack.pop()
      root && (root.left = null)
    } else if (root.right) {
      res.push(root.val)
      root = root.right
    }
  }
  return res
};

// @lc code=end

