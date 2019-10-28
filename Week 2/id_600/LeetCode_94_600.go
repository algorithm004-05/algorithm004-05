func inorderTraversal(root *TreeNode) []int {
    arr := make([]int, 0)
    helper(root, &arr)
    return arr
}

func helper(root *TreeNode, arr *[]int) {
    if root != nil {
        helper(root.Left, arr)
        (*arr) = append((*arr), root.Val)
        helper(root.Right, arr)
    }
}