/**
 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    let levels = []
    if (!root) {
        return levels;
    }
    //helper(levels, root, 0)
    helper2(levels, root)
    return levels;
};

//1、递归算法,每个节点访问一次，每个节点存储一次，所以时间和空间复杂度都是O(n)
let helper = function (result, node, level) {
    //1、递归截止条件 recursive termination
    if (!node) {
        return
    }
    //2、处理 process
    if (result[level]) {
        result[level].push(node.val)
    } else {
        result[level] = [node.val]
    }

    //3、drill down
    if (node.left) {
        helper(result, onde.elft, level + 1)
    }
    if (node.right) {
        helper(result, node.right, level + 1)
    }
}

//2、迭代法
let helper2 = function (result, root) {
    let que = [root]
    let level = 0
    while (que.length > 0) {
        result.push([])
        let len = que.length
        for (let i = 0; i < len; i++) {
            let node = que.shift()
            result[level].push(node.val)

            if (node.left) {
                que.push(node.left)
            }
            if (node.right) {
                que.push(node.right)
            }
        }
        level++
    }
}
