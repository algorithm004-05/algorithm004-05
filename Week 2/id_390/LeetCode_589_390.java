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
// 1. 递归
// 2. 迭代
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Node pre = null;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node current = stack.peek();
            output.add(current.val);
            stack.pop();
            // 将该节点的子节点从右往左压入栈
            if(current.children.size() != 0) {
                for(int i = current.children.size() - 1; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
