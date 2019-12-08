package lsn06.tree;

import java.util.ArrayList;
import java.util.List;

import lsn06.tree.LeetCode_94_555.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 *  示例:
 * 
 * 输入: [1,null,2,3]
 * 
 * 1 \ 2 / 3
 * 
 * 输出: [1,2,3]
 *
 * 
 */
public class LeetCode_144_555 {

	public static void main(String[] args) {
		LeetCode_144_555 leetcode = new LeetCode_144_555();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node3.left = null;
		node3.right = null;
		node2.left = node3;
		node2.right = null;
		node1.left = null;
		node1.right = node2;
		List<Integer> list = leetcode.preorderTraversal(node1);
		System.out.println(list.toString());

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			if (root.left != null) {
				helper(root.left, res);
			}
			if (root.right != null) {
				helper(root.right, res);
			}
		}
	}

}
