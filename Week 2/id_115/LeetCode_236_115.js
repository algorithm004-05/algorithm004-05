/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  let res = ''
  function helper(root, p, q) {
    if (!root) return false
    let left = helper(root.left, p, q) ? 1 : 0
    let right = helper(root.right, p, q) ? 1 : 0
    let mid = (root === p || root === q) ? 1 : 0
    if (left + right + mid >= 2) {
      res = root
    }
    if (left + right + mid > 0) return true
  }
  helper(root, p, q)
  return res
};
var lowestCommonAncestor = function (root, p, q) {
  let stack = [root]
  let parent = new Map()
  parent.set(root, null)
  while (!parent.has(p) || !parent.has(q)) {
    let root = stack.pop()
    if (root.left) {
      stack.push(root.left)
      parent.set(root.left, root)
    }
    if (root.right) {
      stack.push(root.right)
      parent.set(root.right, root)
    }
  }
  let set = new Set()
  while (p) {
    set.add(p)
    p = parent.get(p)
  }
  while (!set.has(q)) {
    q = parent.get(q)
  }
  return q
};
// @lc code=end

