/*
 * @lc app=leetcode.cn id=429 lang=cpp
 *
 * [429] N叉树的层序遍历
 */
#include <queue>
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
//solution1 iteratively  queue
    // vector<vector<int>> levelOrder(Node* root) {
    //     queue<Node *> q;
    //     vector<vector<int>> res;
    //     Node * temp;
    //     if (root==NULL)return res;
    //     q.push(root);
    //     // rec.push_back(temp->val);
    //     while (!q.empty())
    //     {
    //         vector<int> rec;
    //         for (int i = q.size(); i >0; i--)
    //         {
    //             temp=q.front();
    //             rec.push_back(temp->val);
    //             for (auto c :temp->children) q.push(c);
    //             q.pop();
    //         }
    //         res.push_back(rec);
    //     }
        
    //     return res;
    // }
    //sulotion2 recursively
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        recur(root,0,res);
        return res;
    }
    void recur(Node* node,int deepth,vector<vector<int>> &res){
        if (node)
        {
            if(deepth+1>res.size()) {
                vector<int> temp;
                res.push_back(temp);
            }
            res[deepth].push_back(node->val);
            for(auto n:node->children)recur(n,deepth+1,res);
        }
        
    }
};
// @lc code=end

