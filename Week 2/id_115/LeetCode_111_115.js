/*
 * @lc app=leetcode.cn id=111 lang=javascript
 *
 * [111] 二叉树的最小深度
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
 * @return {number}
 */
var minDepth = function (root) {
  if (!root) return 0
  if (!root.left && !root.right) return 1
  let res = Number.MAX_SAFE_INTEGER
  if (root.left) {
    res = Math.min(minDepth(root.left), res)
  }
  if (root.right) {
    res = Math.min(minDepth(root.right), res)
  }
  return res + 1
};
var minDepth = function (root) {
  if (!root) return 0
  let stack = [{
    key: root,
    val: 1
  }]
  let depth = Number.MAX_SAFE_INTEGER
  while (stack.length) {
    let current = stack[stack.length - 1].val
    let node = stack.pop().key
    if (!node.left && !node.right) {
      depth = Math.min(depth, current)
    }
    if (node.left) {
      stack.push({
        key: node.left,
        val: current + 1
      })
    }
    if (node.right) {
      stack.push({
        key: node.right,
        val: current + 1
      })
    }
  }
  return depth
};
var minDepth = function (root) {
  if (!root) return 0
  let stack = [{
    key: root,
    val: 1
  }]
  let current = 1
  while (stack.length) {
    current = stack[0].val
    let node = stack.shift().key
    if (!node.left && !node.right) {
      break
    }
    if (node.left) {
      stack.push({
        key: node.left,
        val: current + 1
      })
    }
    if (node.right) {
      stack.push({
        key: node.right,
        val: current + 1
      })
    }
  }
  return current
};
// @lc code=end

