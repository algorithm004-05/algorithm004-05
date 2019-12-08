/*
 * @lc app=leetcode.cn id=98 lang=javascript
 *
 * [98] 验证二叉搜索树
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
 * @return {boolean}
 */
var isValidBST = function (root) {
  let res = []
  let flag = true
  function helper(root) {
    if (!root) return
    helper(root.left)
    res.push(root.val)
    if (res.length > 1) {
      if (res[res.length - 1] <= res[res.length - 2]) {
        flag = false
        return
      }
    }
    helper(root.right)
  }
  helper(root)
  return flag
};
var isValidBST = function (root) {
  let stack = []
  let lastNum = -Number.MAX_VALUE
  while (stack.length || root) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    root = stack.pop()
    if (lastNum >= root.val) {
      return false
    }
    lastNum = root.val
    root = root.right
  }
  return true
};

var isValidBST = function (root) {

  function helper(root, up, down) {
    if (!root) return true
    let num = root.val
    if (num <= down && down !== null) return false
    if (num >= up && up !== null) return false
    if (!helper(root.right, up, num)) return false
    if (!helper(root.left, num, down)) return false
    return true
  }
  return helper(root, null, null)
};
// @lc code=end

