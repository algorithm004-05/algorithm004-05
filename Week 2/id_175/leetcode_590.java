//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
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
class leetcode_590 {
	private List<Integer> res = new ArrayList<>();
	
	public List<Integer> postorder(Node root) {
		isPosOrdTrav(root, res);
		return res;
	}
	
	private void isPosOrdTrav(Node root, List<Integer> res) {
		if (root != null) {
			for (int i = 0; i < root.children.size(); i++) {
				isPosOrdTrav(root.children.get(i), res);
			}
			res.add(root.val);
		}
	}
	
	//修改过后的后序遍历
	private void isPosOrdTrav(Node root, List<Integer> res) {
		if (root != null) {
			for (Node child : root.children) {
				isPosOrdTrav(child, res);
			}
			res.add(root.val);
		}
	}
	
	//非递归
	private void isPosOrdTrav(Node root, List<Integer> res) {
		Stack<Node> stackRes = new Stack<>();
		Stack<Node> stackTmp = new Stack<>();
		stackRes.push(root);
		while (!stackRes.isEmpty()) {
			Node cur = stackRes.pop();
			stackTmp.push(cur);
			for (Node child : cur.children) {
				stackRes.push(child);
			}
		}
		while (!stackTmp.isEmpty()) {
			res.add(stackTmp.pop().val);
		}
	}
	
	
	/**
	 * 修改之后的栈方法
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> list = isPosOrdTrav(root);
		return list;
	}
	
	
	private List<Integer> isPosOrdTrav(Node root) {
		List<Integer> list = new LinkedList<>();
		Stack<Node> stackRes = new Stack<>();
		stackRes.push(root);
		while (!stackRes.isEmpty()) {
			Node cur = stackRes.pop();
			list.add(0, cur.val);
			for (Node child : cur.children) {
				stackRes.push(child);
			}
		}
		return list;
	}
	
}
//leetcode submit region end(Prohibit modification and deletion)
