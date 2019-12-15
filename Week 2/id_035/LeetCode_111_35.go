package partical

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索



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
	思路1:递归, 在递归上面基本思路和求最大深度应该是一样的、但这里要注意的一个问题是
	如果该树只有左节点或者只有右节点、则其深度就是链表长度(链表由二叉树退化得到)
	当 root 节点左右孩子都为空时，返回 1
	当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
	当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
*/
func minDepth(root *TreeNode) int {
	// terminal condition
	if root.Left == nil  && root.Right == nil{
		return 1
	}
	// processor logic in current level
	if root.Left != nil && root.Right == nil {
		// drill down
		return minDepth(root.Left)
	}
	if root.Left == nil && root.Right != nil {
		// drill down
		return minDepth(root.Right)
	}
	// drill down
	return _min(minDepth(root.Left), minDepth(root.Right))
}
//leetcode submit region end(Prohibit modification and deletion)

func _min(left int, right int) int {
	if left < right {
		return left
	} else {
		return right
	}
}