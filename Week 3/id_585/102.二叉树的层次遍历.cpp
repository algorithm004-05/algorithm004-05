/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层次遍历
 */

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
 //dfs
//class Solution {
//public:
//        vector<vector<int>> res;
//    vector<vector<int>> levelOrder(TreeNode* root) {
//        recur(0, root);
//        return res;
//    }
//
//    void recur(int depth, TreeNode* root ) {
//           if(!root) return;
//           if(depth >= res.size())
//           res.push_back(vector<int>{});
//           res[depth].push_back(root->val);
//           if(root->left) recur(depth + 1, root->left);   
//           if (root->right) recur(depth + 1, root->right);   
//        }
//};
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) {return {};}
        vector<vector<int>> res;
        queue<TreeNode*> node;
        node.push(root);
        vector<int> levelRes;
        int count = 1;
        while(!node.empty()){
            if(node.front()->left) {node.push(node.front()->left);}
            if(node.front()->right) {node.push(node.front()->right);}
            levelRes.push_back(node.front()->val), node.pop();
            if(--count == 0){
                res.push_back(levelRes);
                levelRes.clear();
                count = node.size();
            }
    }
         return res;
    }
};
//bfs only one queue is used / use NULL as marker for next level
//class Solution {
//public:
//    vector<vector<int>> levelOrder(TreeNode* root) {
//        vector<vector<int>> res;
//        queue<TreeNode*> node;
//        if(!root){
//		    return res;
//	    }
//        node.push(root);
//        node.push(NULL);
//        vector<int> levelRes;
//        while(!node.empty()){
//            TreeNode* temp = node.front();
//            node.pop();
//            
//            if(temp == NULL){
//                res.push_back(levelRes);
//                levelRes.resize(0);
//                if(node.size()>0)
//                node.push(NULL);
//            }
//            else{
//                levelRes.push_back(temp->val);
//                if (temp->left)
//                    node.push(temp->left);
//                if (temp->right)
//                    node.push(temp->right);
//
//            }
//        }
//        return res;
//    }
//};
// @lc code=end

