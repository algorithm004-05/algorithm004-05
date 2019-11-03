package main

func main() {
	
}

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//前序第一个肯定是根
//用根可以把中序的划分为左右子树，然后递归
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	
	root := &TreeNode{
		Val:preorder[0],
		Left:nil,
		Right:nil,
	}
	
	if len(preorder) == 1 {
		return root
	}
	
	idx := 0
	for idx = 0;preorder[0]!=inorder[idx];idx++{
	}
	root.Left = buildTree(preorder[1:idx+1],inorder[:idx])
	root.Right = buildTree(preorder[idx+1:],inorder[idx+1:])
	return root
}
