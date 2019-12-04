package main

func main() {
	
}

var result []int
func preorderTraversal(root *TreeNode) []int {
	result = []int{}
	preorder(root)
	return result
}

func preorder(root *TreeNode) {
	if root == nil {
		return
	}
	result = append(result, root.Val)
	preorder(root.Left)
	preorder(root.Right)
}


