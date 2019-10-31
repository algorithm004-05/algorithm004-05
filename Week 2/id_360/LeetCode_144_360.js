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

var preorderTraversal = function(root) {
    let res = []
    traversal(root, res);
    return res
};
function traversal(root, res) {
    if (root != null) {
        res.push(root.val);
        if (root.left != null) {
            traversal(root.left, res);
        }
        if (root.right != null) {
            traversal(root.right, res);
        }
    }
}