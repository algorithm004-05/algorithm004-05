package partical

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */


type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

/*
	思路1:递归
	算出其左右子节点的深度、取其中大的那一个+1就是其最大深度
*/
func maxDepth(root *TreeNode) int {
	if nil == root {
		return 0
	}
	left_count := maxDepth(root.Left)
	right_count := maxDepth(root.Right)
	return _max(left_count, right_count) + 1
}

func _max(left int, right int) int {
	if left > right {
		return left
	} else {
		return right
	}
}
//leetcode submit region end(Prohibit modification and deletion)
