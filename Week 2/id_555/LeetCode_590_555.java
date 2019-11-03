package lsn06.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * 590. N叉树的后序遍历
 *
 * 
 */
public class LeetCode_590_555 {
	public static void main(String[] args) {

		LeetCode_590_555 leetcode = new LeetCode_590_555();

		Node node2 = new Node(2, new ArrayList<Node>());
		Node node4 = new Node(4, new ArrayList<Node>());
		Node node5 = new Node(5, new ArrayList<Node>());
		Node node6 = new Node(6, new ArrayList<Node>());

		List<Node> chList3 = new ArrayList<Node>();
		chList3.add(node5);
		chList3.add(node6);
		Node node3 = new Node(3, chList3);

		List<Node> chList1 = new ArrayList<Node>();
		chList1.add(node3);
		chList1.add(node2);
		chList1.add(node4);
		Node root = new Node(1, chList1);

		List<Integer> res = leetcode.postorder(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> postorder(Node root) {
		helper(root);
		return res;
	}

	public void helper(Node root) {
		if (root == null) {
			return;
		}
		int s = root.children.size();
		for (int i = 0; i < s; i++) {
			helper(root.children.get(i));
		}
		res.add(root.val);
	}

	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
