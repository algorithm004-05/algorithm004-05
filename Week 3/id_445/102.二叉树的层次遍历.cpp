/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层次遍历
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
///solution 1 bfs
    

//      vector<vector<int>> levelOrder(TreeNode* root) {
//         vector<vector<int>> res;
//         queue<TreeNode *> q;
//         if(root)q.push(root);
//         int size=0;
        
//         TreeNode * n;
// ////good solution
//         // while (!q.empty())
//         // {
//         //     size=q.size();
//         //     vector<int> vec;
//         //     for (int i = 0; i < size; i++)
//         //     {
//         //         n=q.front();
//         //         vec.push_back(n->val);
//         //         q.pop();
//         //         if(n->left)q.push(n->left);
//         //         if(n->right)q.push(n->right);
//         //     }
//         //     res.push_back(vec);
            

//         // }

//         ///bad solution
//         vector<int> *vec=new vector<int>();
//         int i=0;
//         size=q.size();
//         while (i < size)
//         {
            
//             n=q.front();
//             vec->push_back(n->val);
//             q.pop();
//             if(n->left)q.push(n->left);
//             if(n->right)q.push(n->right);
//             i++;
//             if (vec->size()==size)
//             {
//                 size=q.size();
//                 i=0;
//                 res.push_back(*vec);
//                 vec=new vector<int> ;
//             }
            
//         }
        
        
//         return res;
//     }
    ///solution2 dfs
    vector<vector<int>> levelOrder(TreeNode* root) {
vector<vector<int>> res;
if(!root) return res;
dfs(root,0,res);
return res;
    }
    void dfs(TreeNode* node,int level,vector<vector<int>> &res){
        if(res.size()==level){
            res.push_back(vector<int>{});
        }
        res[level].push_back(node->val);
        if (node->left)dfs(node->left,level+1,res);
        if(node->right)dfs(node->right,level+1,res);
        
    }
};
// @lc code=end

