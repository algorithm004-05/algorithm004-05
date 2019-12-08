package main

func main() {
	
}
//中序遍历 左-根-右
var result []int
func inorderTraversal(root *TreeNode) []int {
	result = []int{}
	inorder(root)
	return result
}

func inorder(root *TreeNode) {
	//终止
	if root == nil {
		return
	}
	
	//左子树
	inorder(root.Left)
	result = append(result, root.Val)
	//右子树
	inorder(root.Right)
}
