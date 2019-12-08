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
var inorderTraversal = function (root) {
    if (!root) return [];
    var res = [];
    res = res.concat(inorderTraversal(root.left))
    res.push(root.val)  //位置不同决定不同遍历方式
    res = res.concat(inorderTraversal(root.right))
    return res;
};