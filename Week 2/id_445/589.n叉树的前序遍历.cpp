/*
 * @lc app=leetcode.cn id=589 lang=cpp
 *
 * [589] N叉树的前序遍历
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
class Solution {
public:
//solution 1 recursively
    // vector<int> preorder(Node* root) {
    //     vector<int> res;
    //     recur(root,res);
    //     return res;
    // }
    // void recur(Node* root,vector<int> &res){
    //     if (root)
    //     {
    //         res.push_back(root->val);
    //        for (auto n:root->children)
    //        {
    //            recur(n,res);
    //        }
           
    //     }
        
    // }
    //solution2 iteratively
     vector<int> preorder(Node* root) {
         stack<Node *> s;
         vector<int> res;
         Node *temp;
         
         if(root==NULL) return res;
        //  res.push_back(root->val);
         s.push(root);
         while (!s.empty())
         {
            temp=s.top();
            res.push_back(temp->val);
            s.pop();
             for (int i = temp->children.size()-1; i>=0 ; i--)
             {
                 s.push(temp->children[i]);
             }
             
             
         }
         
         return res;
     }
};
// @lc code=end

