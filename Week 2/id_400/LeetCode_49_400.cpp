class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> hashmap;
        vector<vector<string>> result;
        for (int i = 0; i < strs.size(); ++i) {
            string tmp = strs[i];
            sort(tmp.begin(), tmp.end());
            hashmap[tmp].push_back(strs[i]);
        }
        for(auto it = hashmap.begin(); it != hashmap.end(); ++it) {
            result.push_back(it->second);            
        }
        return result;
    }
};
