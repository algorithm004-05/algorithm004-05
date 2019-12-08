/*
 * @lc app=leetcode.cn id=104 lang=javascript
 *
 * [104] 二叉树的最大深度
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
var maxDepth = function (root) {
  function helper(root) {
    if (!root) return 0
    let left = helper(root.left)
    let right = helper(root.right)
    return Math.max(left, right) + 1
  }
  return helper(root)
};
var maxDepth = function (root) {
  let stack = [{
    key: root,
    val: 1
  }]
  let depth = 0
  while (stack.length) {
    let node = stack.pop()
    let cur = node.key
    if (cur) {
      depth = Math.max(depth, node.val)
      if (cur.left) {
        stack.push({
          key: cur.left,
          val: node.val + 1
        })
      }
      if (cur.right) {
        stack.push({
          key: cur.right,
          val: node.val + 1
        })
      }
    }
  }
  return depth
};
// @lc code=end

