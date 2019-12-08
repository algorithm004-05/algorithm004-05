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
    
    public void getNode(Node root, List<Integer> list) {
        
        if (root != null) {
            
            for (int i=0; i<root.children.size(); i++) {
                getNode(root.children.get(i), list);
            }
            
            list.add(root.val);
        }
    }
    
    public List<Integer> postorder(Node root) {
                
        List<Integer> list = new ArrayList<Integer>();

        getNode(root, list);
        
        return list;
    }
}
