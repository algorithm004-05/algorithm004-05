/*
 * @lc app=leetcode.cn id=226 lang=javascript
 *
 * [226] 翻转二叉树
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
 * @return {TreeNode}
 */
var invertTree = function (root) {
  if (!root) return null
  let right = invertTree(root.right)
  let left = invertTree(root.left)
  root.right = left
  root.left = right
  return root
};
var invertTree = function (root) {
  if (!root) return null
  let stack = []
  stack.push(root)
  while (stack.length) {
    let cur = stack.pop()
    let temp = null
    temp = cur.right
    cur.right = cur.left
    cur.left = temp

    cur.left && stack.push(cur.left)
    cur.right && stack.push(cur.right)
  }
  return root
};
// @lc code=end

