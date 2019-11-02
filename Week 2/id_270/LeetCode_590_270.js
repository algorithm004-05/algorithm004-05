/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */

function push(node, result) {
  if (node !== null) {
    if (node.children != null) {
      for (var i = 0; i < node.children.length; i++) {
        push(node.children[i], result);
      }
    }
    result.push(node.val);
  }
}

var postorder = function (root) {
  var result = [];
  push(root, result);
  return result;
};