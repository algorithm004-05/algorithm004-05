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
// 1. 递归
// 2. 迭代
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<Integer>();
        helper(root, output);
        return output;
    }
    private void helper(Node root, List<Integer> output) {
        if(root != null) {
            for(Node node : root.children) {
                helper(node, output);
            }
            output.add(root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
