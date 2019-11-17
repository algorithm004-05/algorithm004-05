//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class leetcode_144 {
	private List<Integer> res = new ArrayList<>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		isPreTraver(root, res);
		return res;
	}
	
	private void isPreTraver(TreeNode root, List<Integer> res) {
		if (root != null) {
			//根
			res.add(root.val);
			//左
			if (root.left != null) {
				isPreTraver(root.left, res);
			}
			//右
			if (root.right != null) {
				isPreTraver(root.right, res);
			}
		}
	}
	
	/**
	 * 使用栈的方式
	 *
	 * @param root
	 * @param res
	 */
	private void isPreTraver(TreeNode root, List<Integer> res) {
		Stack<TreeNode> stack = new Stack<>();
		if (root != null) {
			//根
			stack.push(root);
			while (!stack.empty()) {
				root = stack.pop();
				res.add(root.val);
				//左
				if (root.left != null) {
					stack.push(root.left);
				}
				//右
				if (root.right != null) {
					stack.push(root.right);
				}
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
