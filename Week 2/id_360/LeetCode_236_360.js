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

// 查找到p、q后返回各自父节点，当父节点相同时返回结果
function lowestCommonAncestor(root, p, q) {
    if (!root || root === p || root === q) return
    let resL = lowestCommonAncestor(root.left, p, q)
    let resR = lowestCommonAncestor(root.right, p, q)
    return (resL && resR) ? root : (resL || resR)
}