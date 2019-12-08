/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
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
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null) return lst;
        lst.add(root.val);
        preHelper(lst,root);
        return lst;
    }
    public static void preHelper(List<Integer>lst,Node node) {
        if(node == null) return;
        List<Node> childList = node.children;
        for(int i = 0; i < childList.size() ; i++) {
            lst.add(childList.get(i).val);
            preHelper(lst,childList.get(i));
        }
    }
}
// @lc code=end

