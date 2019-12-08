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
    
    public void getNode(Node root, List<List<Integer>> list, int depth) {
        
        // if (depth > 1000) {
        //     throw new Exception("depth beyound 1000");
        // }
        
        if (root != null) {
            
            if (list.size() == depth) {
                list.add(new ArrayList<Integer>());
            }
            
            list.get(depth).add(root.val);
            
            for (int i=0; i<root.children.size(); i++) {
                getNode(root.children.get(i), list, depth+1);
            }
        }
    }
    
    public List<List<Integer>> levelOrder(Node root) {
                
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        getNode(root, list, 0);
        
        return list; 
    }
}
