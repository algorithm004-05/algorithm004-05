package geektime.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversal {

    public ArrayList<Integer> preorder(TreeNode root,ArrayList<Integer> treeNodeList) {
        if (null != root) {
            if (null != root.getLeft()) {
                preorder(root.getLeft(),treeNodeList);
            }
            treeNodeList.add(root.getVal());
            if (null != root.getRight()) {
                preorder(root.getRight(),treeNodeList);
            }
        }
        return treeNodeList;
    }

    public ArrayList<Integer> preOrderByStack(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        ArrayList<Integer> treeNodeList = new ArrayList<Integer>();
        TreeNode curr = root;
        while (null != curr || !deque.isEmpty()) {
            while (null != curr) {
                deque.addFirst(curr);
                curr = curr.left;
            }
            curr = deque.getFirst();
            treeNodeList.add(curr.getVal());
            curr = curr.right;
        }
        return treeNodeList;
    }
//递归代码模板
   /* public void recur(int level,int param) {
        //terminatorn
        if (level > MAX_LEVEL) {
            //process result递归总结条件
            return;
        }
        //process current logic处理当前层逻辑
        process(level,param);

        //drill down下探到下一层
        recur(level:level+1,newParam);

        //restore current status清理当前层

    }*/


/*   public void recur(int level, int param) {
       if (level < MAX_LEVEL) {
           return;
       }
       process(level,param);

       recur(level:level+1,newParam);

       //rostore current status;
   }*/

}
