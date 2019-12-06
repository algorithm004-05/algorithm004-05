import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
    public List<Integer> postorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if(root == null)return lst;
        
        postHelper(lst,root);
        lst.add(root.val);
        return lst;
    }
    public static void postHelper(List<Integer>lst,Node node) {
        if(node == null) return;

        // postHelper(lst, node.left);
        List<Node> childList = node.children;
        for(int i = 0 ; i < childList.size() ; i++) {            
            postHelper(lst,childList.get(i));
            lst.add(childList.get(i).val);
        }
       
    }
}
// @lc code=end

