//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索



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
// 1. 使用两个数组进行交叉持有节点
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) {
            return output;
        }
        List<Node> listOne = new ArrayList<Node>();
        List<Node> listTwo = new ArrayList<Node>();
        listOne.add(root);
        while(!listOne.isEmpty() || !listTwo.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            if(!listOne.isEmpty()) {
                for(int i = 0; i < listOne.size(); i++) {
                    Node current = listOne.get(i);
                    list.add(current.val);
                    for(Node node : current.children) {
                        listTwo.add(node);
                    }
                }
                listOne.clear();
                output.add(list);
                continue;
            }
            if(!listTwo.isEmpty()) {
                for(int i = 0; i < listTwo.size(); i++) {
                    Node current = listTwo.get(i);
                    list.add(current.val);
                    for(Node node : current.children) {
                        listOne.add(node);
                    }
                }
                listTwo.clear();
                output.add(list);
                continue;
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
