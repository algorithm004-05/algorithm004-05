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

var levelOrder = function(root) {
    let res = []
    traversal(root, res, 0);
    return res
};
function traversal(root, res, k) {
    if (root != null) {
        if (res[k] === undefined) {
            res[k] = []
        }
        res[k].push(root.val);
        for (let i = 0; i < root.children.length; i++) {
            traversal(root.children[i], res, k + 1)
        }
    }
}