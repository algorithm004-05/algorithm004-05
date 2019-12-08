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
    result.push(node.val);
    if (node.left != null) {
      push(node.left, result);
    }
    if (node.right !== null) {
      push(node.right, result);
    }
  }
}
var preorderTraversal = function (root) {
  var result = [];
  push(root, result);
  return result;
};