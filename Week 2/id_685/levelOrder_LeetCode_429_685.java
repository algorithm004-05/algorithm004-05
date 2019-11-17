/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if(root == null) return lst;

        levelHelper(lst,root,0);
        return lst;

    }
    public static void levelHelper(List<List<Integer>>lst,Node node,int level) {
        if(node == null)return;
        if(level+1 > lst.size()) {
            lst.add(level,new ArrayList<Integer>());
        }
        lst.get(level).add(node.val);
        for(Node c : node.children) {
            levelHelper(lst, c, level+1);
        }
    }
}
// {
// 	"$id": "1",
// 	"children": [{
// 		"$id": "2",
// 		"children": [{
// 			"$id": "3",
// 			"children": [],
// 			"val": 5
// 		}, {
// 			"$id": "4",
// 			"children": [],
// 			"val": 0
// 		}],
// 		"val": 10
// 	}, {
// 		"$id": "5",
// 		"children": [{
// 			"$id": "6",
// 			"children": [],
// 			"val": 6
// 		}],
// 		"val": 3
// 	}],
// 	"val": 1
// }
// @lc code=end

