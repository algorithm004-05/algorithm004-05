package lsn09.bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * 
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 */
public class LeetCode_102_555 {

	public static void main(String[] args) {
		LeetCode_102_555 leetcode = new LeetCode_102_555();
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);

		TreeNode node6 = new TreeNode(6);

//	node1=null;

		node1.left = node2;
		node1.right = node3;
//		node2.left = null;
//		node2.right = null;

		node2.left = node6;
		node2.right = null;

		node3.left = node4;
		node3.right = node5;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = null;

		node6.left = null;
		node6.right = null;

//		print(leetcode.levelOrder2(node1));;
		print(leetcode.levelOrder1(node1));;
		

	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null)
			return wrapList;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper2(res, root, 0);
		return res;
	}

	public void levelHelper2(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null)
			return;
		if (height >= res.size()) {
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.val);
		levelHelper2(res, root.left, height + 1);
		levelHelper2(res, root.right, height + 1);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

//	public void print(List<List<Integer>> levels) {
//		System.out.println("[");
//		for (int i = 0; i < levels.size(); i++) {
//			List<Integer> chList = levels.get(i);
//			System.out.println("  "+chList.toString() + ",");
//
//		}
//		System.out.print("]");
//	}

	public static void print(List<List<Integer>> levels) {
		System.out.println(levels.toString());
	}

}
