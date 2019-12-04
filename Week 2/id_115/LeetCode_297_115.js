/*
 * @lc app=leetcode.cn id=297 lang=javascript
 *
 * [297] 二叉树的序列化与反序列化
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
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
  let stack = [root]
  let res = []
  while (stack.length) {
    let root = stack.shift()
    if (root) {
      res.push(root.val)
      stack.push(root.left)
      stack.push(root.right)
    } else {
      res.push(null)
    }
  }
  return res.join(',')
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  let data = data.split(',')
  let index = 0
  let parent = []
  let root = null
  while (index < data.length) {
    if (!parent.length) {
      if (!data[index]) return null
      root = new TreeNode(data[index])
      parent.push(root)
      index++
    }
    let p = parent.shift()
    if (!data[index]) {
      p.left = null
    } else {
      p.left = new TreeNode(data[index])
      parent.push(p.left)
    }
    index++
    if (!data[index]) {
      p.right = null
    } else {
      p.right = new TreeNode(data[index])
      parent.push(p.right)
    }
    index++
  }
  return root
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
// @lc code=end

