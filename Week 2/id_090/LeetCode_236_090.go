package main

func main() {
	
}

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
 //在递归过程中，对于遍历到的结点进行一下判断：该点左子树是否含有pq中的一个、右子树是否含有pq中的一个。若是，则将此点作为结果赋值给res。
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == q || root == p {
		return root
	}
	
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	
	if left != nil {
		if right != nil {
			return root
		}
		
		return left
	}
	
	return right
}
