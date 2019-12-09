class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())
            return false;
        
        int anagram_count[26] = {0};
        int index = 0;
        for (int i = 0; i < s.size(); i++) {
            index = s[i] - 'a';
            anagram_count[index]++;
            index = t[i] - 'a';
            anagram_count[index]--;
        }
        for (int i = 0; i < 26; i++) {
            if (anagram_count[i] != 0)
                return false;
        }
        return true;
    }
};
