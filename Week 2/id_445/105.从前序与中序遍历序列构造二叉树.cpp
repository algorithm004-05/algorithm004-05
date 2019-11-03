/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */
#include <vector>
#include <algorithm>
using namespace std;
/**
 * 
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        
        return recur(preorder,0,preorder.size(),inorder,0,inorder.size());
        
    }
    TreeNode* recur(vector<int> &preorder,int pstart,int pend,vector<int>& inorder,int istart,int iend){
         
         if(pstart>=pend) return nullptr;
         if(pstart==pend-1) return new TreeNode(preorder[pstart]);
         int h=preorder[pstart],m=0;
         TreeNode * node=new TreeNode(preorder[pstart]);
         while (istart+m<iend)
         {
             if(inorder[istart+m]==h) break;
             m++;
         }
        node->left=recur(preorder,pstart+1,pstart+m+1,inorder,istart,istart+m+1);
        node->right=recur(preorder,pstart+m+1,pend,inorder,istart+m+1,iend);
        return node;
    }

};
// @lc code=end

