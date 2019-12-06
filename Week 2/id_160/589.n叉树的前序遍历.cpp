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
// class Solution {
// public:
//     vector<int> preorder(Node* root) {
//         vector<int> result;
//         travel(root, result);
//         return result;
//     }
// private:
//     void travel(Node* root, vector<int>& result) {
//         if (root == nullptr) {
//             return;
//         }
        
//         result.push_back(root -> val);
//         for (Node* child : root -> children) {
//             travel(child, result);
//         }
//     }
// };

class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> res;
        stack<Node*> st;
        if (root) st.push(root);
        while (!st.empty()) {
            root = st.top(); st.pop();
            res.push_back(root->val);
            for (auto iter = root->children.rbegin(); iter != root->children.rend(); iter++) {
                if (*iter) st.push(*iter);
            }
        }
        return res;
    }
};
// @lc code=end

