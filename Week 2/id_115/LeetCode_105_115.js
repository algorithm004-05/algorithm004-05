/*
 * @lc app=leetcode.cn id=105 lang=javascript
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function (preorder, inorder) {
  function helper(p, p_start, p_end, i, i_start, i_end) {
    if (p_start === p_end) {
      return null
    }
    let rootNum = p[p_start]
    let root = new TreeNode(rootNum)
    let i_root_index = 0
    for (let j = i_start; j < i_end; j++) {
      if (rootNum === i[j]) {
        i_root_index = j
        break
      }
    }
    let leftNum = i_root_index - i_start
    root.left = helper(p, p_start + 1, p_start + 1 + leftNum, i, i_start, i_root_index)
    root.right = helper(p, p_start + 1 + leftNum, p_end, i, i_root_index + 1, i_end)
    return root
  }
  return helper(preorder, 0, preorder.length, inorder, 0, inorder.length)
};
var buildTree = function (preorder, inorder) {
  let map = new Map()
  inorder.map((i, index) => {
    map.set(i, index)
  })
  function helper(p, p_start, p_end, i, i_start, i_end) {
    if (p_start === p_end) {
      return null
    }
    let rootNum = p[p_start]
    let root = new TreeNode(rootNum)
    let i_root_index = map.get(rootNum)

    let leftNum = i_root_index - i_start
    root.left = helper(p, p_start + 1, p_start + 1 + leftNum, i, i_start, i_root_index)
    root.right = helper(p, p_start + 1 + leftNum, p_end, i, i_root_index + 1, i_end)
    return root
  }
  return helper(preorder, 0, preorder.length, inorder, 0, inorder.length)
};
// @lc code=end

