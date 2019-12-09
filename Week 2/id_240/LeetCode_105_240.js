/**
 * 给定前序和中序遍历的结果，反向形成二叉树
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
var buildTree = function(preorder, inorder) {
    if(preorder.length === 0 && inorder.length === 0){
        return null
    }
    let root = {}
    root.val = preorder[0]
    let rootIndexOrder = inorder.indexOf(root.val)

    let leftTreeInOrder = inorder.slice(0,rootIndexOrder)
    let leftTreePreOrder = preorder.slice(1,leftTreeInOrder.length+1)
    root.left = buildTree(leftTreePreOrder,leftTreeInOrder)


    let rightTreeInOrder = inorder.slice(rootIndexOrder+1)
    let rightTreePreOrder = preorder.slice(rootIndexOrder+1)//右侧在pre和in中的位置一致
    root.right = buildTree(rightTreePreOrder,rightTreeInOrder)

    return root;
};