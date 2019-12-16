class Solution {
public:
    int longestValidParentheses(string s) {
        vector<bool> paired_vec(s.length(), false);
        for (int i=1; i<s.length(); ++i) {
            if (s[i] == '(') {
                paired_vec[i] = false;
            }else {
                if (paired_vec[i-1] == false && s[i-1] == '(') {
                    paired_vec[i-1] = true;
                    paired_vec[i] = true;
                }else if (paired_vec[i-1] == true) {
                    for (int j=i-1; j>=0; --j) {
                        if (paired_vec[j] == false && s[j] == '(') {
                            paired_vec[j] = true;
                            paired_vec[i] = true;
                            break;
                        }else if (paired_vec[j] == false) {
                            break;
                        }
                    }
                }
            }
        }
        
        int max_sum = 0;
        int cur_sum = 0;
        for (int i=0; i<s.length(); ++i) {
            if (paired_vec[i]) {
                ++cur_sum;
            }else{
                cur_sum = 0;
            }
            max_sum = std::max(cur_sum, max_sum);
        }
        return max_sum;
    }
};