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

function push(node, result) {
  if (node !== null) {
    if (node.left != null) {
      push(node.left, result);
    }
    result.push(node.val);
    if (node.right !== null) {
      push(node.right, result);
    }
  }
}

var inorderTraversal = function (root) {
  var result = [];
  push(root, result);
  return result;
};