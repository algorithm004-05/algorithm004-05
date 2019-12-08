/*
 * @lc app=leetcode.cn id=515 lang=cpp
 *
 * [515] 在每个树行中找最大值
 */
#include <vector>
#include <queue>
using namespace std;
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
//solution bfs
    // vector<int> largestValues(TreeNode* root) {
        
    //     vector<int> res;
    //     if (!root)return res;
    //     int size,maxV=0;
    //     TreeNode* node;
    //     queue<TreeNode*> q;
        
    //     q.push(root);
        
    //     while (!q.empty())
    //     {
    //         size=q.size();
    //         maxV=q.front()->val;
    //         for (int i = 0; i < size; i++)
    //         {
    //         node=q.front();
    //         q.pop();
    //         if(node->left)q.push(node->left);
    //         if(node->right)q.push(node->right);
    //         maxV=node->val>maxV?node->val:maxV;
    //         }
    //         res.push_back(maxV);
    //         maxV=0;
            
    //     }
    //     return res;
        
        
    // }

    //solution dfs  
        vector<int> largestValues(TreeNode* root) {
        
        vector<int> res;
        if (!root)return res;
        
        recur(root,0,res);
        return res;
        
        
    }
    void recur(TreeNode* node,int level,vector<int> &res){
        if(res.size()==level)res.push_back(node->val);
        else res[level]=res[level]>node->val?res[level]:node->val;
        if(node->left)recur(node->left,level+1,res);
        if(node->right)recur(node->right,level+1,res);
    }
    
};
// @lc code=end

