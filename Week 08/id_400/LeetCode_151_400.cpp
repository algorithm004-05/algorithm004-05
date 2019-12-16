class Solution {
public:
    string reverseWords(string s) {
        string ret = "";
        vector<string> tmp;
        unsigned int pos = 0;
        unsigned int n = 0;
        for (size_t i = 0; i < s.size(); ) {
            while (s[i] == ' ' && i < s.size()) {
                i++;
            }
            pos = i;
            while (s[i] != ' ' && i < s.size()) {
                n++;
                i++;
            }
            if (n > 0) {
                tmp.push_back(s.substr(pos, n));
                n = 0;
            }
        }
        for (int i = tmp.size() - 1; i >= 0; i--) {
            ret += tmp[i];
            if (i != 0) {
                ret += " ";
            }
        }
        return ret;
    }
};
