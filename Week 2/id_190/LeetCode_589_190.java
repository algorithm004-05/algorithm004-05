/**
 * N叉树的前序遍历
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        //先根节点
        list.add(root.val);
        //然后依次遍历每个子树
        for(int i=0;i<root.children.size();i++){
           list.addAll(preorder(root.children.get(i))); 
        }
        return list;
    }
}