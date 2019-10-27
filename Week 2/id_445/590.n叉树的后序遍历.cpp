/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 */
#include <algorithm>
using namespace std;
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
class Solution {
public:
// solution 1 recursively
    // vector<int> postorder(Node* root) {
    //     vector<int> res;
    //     recur(root,res);
    //     return res;
    // }
    // void recur(Node* node,vector<int> &res){
    //     if(node){
    //         for (auto n:node->children)
    //         {
    //             recur(n,res);
    //         }
    //         res.push_back(node->val); 
    //     }
    // }

    //solution2 iteratively
    vector<int> postorder(Node* root) {
        stack<Node *> s;
        vector<int> res;
        Node * temp;

        if(root==NULL) return res;
        s.push(root);
        // res.push_back(root->val);
        while (!s.empty())
        {
            temp=s.top();
            s.pop();
            res.push_back(temp->val);
            for( auto n : temp->children){
                s.push(n);
            }
        }
        reverse(res.begin(),res.end());
        return res; 
        
    }
};
// @lc code=end

