//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class leetcode_94 {
	public String rserialize(TreeNode root, String str) {
		if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
		return str;
	}
	
	public String serialize(TreeNode root) {
		return rserialize(root, "");
	}
	
}
//leetcode submit region end(Prohibit modification and deletion)
