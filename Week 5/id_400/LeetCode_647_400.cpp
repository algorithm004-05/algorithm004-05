class Solution {
public:
    int countSubstrings(string s) {
        int res = 0;
        for(int i = 0; i < s.size(); i++) {
            res += help(s, i, i);
            res += help(s, i, i+1);
        }
        return res;
    }
    int help(string s, int start, int end)
    {
        int count = 0;
        while (start >= 0 && end < s.size()) {
            if (s[start] == s[end]) {
                start--;
                end++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
};
