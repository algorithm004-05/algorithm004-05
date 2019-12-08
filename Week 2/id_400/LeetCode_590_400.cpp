class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> result;
        helper(root, result);
        return result;
    }
    void helper(Node* root, vector<int>& result)
    {
        if (root != NULL) {
            for (int i = 0; i < (root->children).size(); i++) {
                Node *child = (root->children)[i];
                if (child)
                    helper(child, result);
            }
            result.push_back(root->val);
        }
    }
};
