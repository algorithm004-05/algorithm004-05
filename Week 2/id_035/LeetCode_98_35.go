package partical

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
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
	// 节点的左子树只包含小于当前节点的数。
	// 节点的右子树只包含大于当前节点的数。
	// 所有左子树和右子树自身必须也是二叉搜索树。
	思路1:递归判断左子节点小于root、右子节点大于root
*/
func isValidBST(root *TreeNode) bool {

	// 进入下一层 drill down
	//return isValidBST(root.Left) && isValidBST(root.Right)
	return _helper(root, nil, nil)
}

func _helper(node *TreeNode, lower *int, upper *int) bool {
	// 终止条件
	if nil == node {
		return true
	}
	// 获取当前节点的val
	val := node.Val
	// 当前执行的逻辑过程
	if nil != lower && node.Val <= *lower {
		return false
	}
	if nil != upper && node.Val >= *upper {
		return false
	}
	// 进入下一层
	if !_helper(node.Right, &val, upper) {
		return false
	}
	if !_helper(node.Left, lower, &val) {
		return false
	}
	return true
}



//leetcode submit region end(Prohibit modification and deletion)
/*
	// 节点的左子树只包含小于当前节点的数。
	// 节点的右子树只包含大于当前节点的数。
	// 所有左子树和右子树自身必须也是二叉搜索树。
	思路1:BST的中序遍历一定是递增的
*/