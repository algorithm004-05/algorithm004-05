class Solution {
public:
    int firstUniqChar(string s) {
        int hashtable[26] = {0};
        for (size_t i = 0; i < s.size(); i++) {
            int index = s[i] - 'a';
            hashtable[index]++;
        }
        for (size_t i = 0; i < s.size(); i++) {
            int index = s[i] - 'a';
            if (hashtable[index] == 1) {
                return i;
            }
        }
        return -1;
    }
};
