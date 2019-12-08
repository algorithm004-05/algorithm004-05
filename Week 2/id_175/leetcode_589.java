//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class leetcode_589 {
	/**
	 * 递归遍历
	 */
	public List<Integer> preorder(Node root) {
		isPreOrdTrav(root, res);
		return res;
	}
	
	private void isPreOrdTrav(Node root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			for (Node child : root.children) {
				isPreOrdTrav(child, res);
			}
		}
	}
	
	//迭代
	public List<Integer> preorder(Node root) {
		isPreOrdTrav(root);
		return res;
	}
	
	private void isPreOrdTrav(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node cur = stack.pop();
				//头结点加入结果
				res.add(cur.val);
				List<Node> nodeList = cur.children;
				for (int i = nodeList.size() - 1; i >= 0; i--) {
					stack.push(nodeList.get(i));
				}
			}
		}
		
	}
	
}
//leetcode submit region end(Prohibit modification and deletion)
