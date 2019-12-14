package main

import "fmt"

func main() {
	var tree *TreeNode
	tree = &TreeNode{ Val: 1 }
	tree.Right = &TreeNode { Val: 2 }
	tree.Right.Left = &TreeNode{ Val: 3 }

	fmt.Println(inorderTraversal(tree))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode

}

func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	r1 := inorderTraversal(root.Left)
	r2 := inorderTraversal(root.Right)
	return append(append(r1, root.Val), r2...)
}
