/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.07%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 15.3K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
//szh 2019-10-25
#define MOD 0
#if MOD
class Solution {
public:
    vector<int> ret;
    vector<int> postorder(Node* root) {
        postTravelN(root);
        return ret;
    }

    void postTravelN(Node *root){
        if(root){
            for(int i =0; i<root->children.size();++i)
                postTravelN(root->children[i]);
            ret.push_back(root->val);
        }
    }
};
#else
class Solution {
public:
        vector<int> postorder(Node* root) {
        
        }
};
// @lc code=end

