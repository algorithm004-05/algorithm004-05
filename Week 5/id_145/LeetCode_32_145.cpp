class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.empty()) {
            return 0;
        }
        
        vector<pair<bool, int>> dp(s.length(), make_pair(false, 0));
        for (int i=1; i<s.length(); ++i) {
            if (s[i] == '(') {
                dp[i].first = false;
                dp[i].second = dp[i-1].second;
            }else{
                if (dp[i-1].first == false && s[i-1] == '(') {
                    dp[i].first = true;
                    dp[i-1].first = true;
                    dp[i].second = dp[i-1].second + 2;
                } else if (dp[i-1].first == false && s[i-1] == ')') {
                    dp[i].first = false;
                    dp[i].second = dp[i-1].second;
                } else if (dp[i-1].first == true) {
                    dp[i].first = false;
                    dp[i].second = dp[i-1].second;
                    for (int j=i-1; j>=0; --j) {
                        if (s[j] == '(' && dp[j].first == false) {
                            dp[i].first = true;
                            dp[i].second = dp[i-1].second + 2;
                            dp[j].first = true;
                            break;
                        }
                    }
                }
            }
        }
        int ret = 0;
        int cur_sum = 0;
        for (int i=0; i<s.length(); ++i)
        {
            cur_sum = dp[i].first ? cur_sum+1 : 0;
            ret = std::max(cur_sum, ret);
        }
        return ret;
    }
};