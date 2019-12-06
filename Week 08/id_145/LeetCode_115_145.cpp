class Solution {
public:
    int numDistinct(string s, string t) {
        if (t.length() > s.length()) {
            return 0;
        }

        int m=static_cast<int>(s.length());
        int n=static_cast<int>(t.length());
        vector<vector<long>> func_nums(n+1, vector<long>(m+1, 0));
        for (int i=0; i<=m; ++i) {
            func_nums[0][i] = 1;
        }
        for (int i=1; i<=n; ++i) {
            func_nums[i][0] = 0;
        }
        
        for (int i=1; i<=n; ++i) {
            for(int j=1; j<=m; ++j) {
                if (s[j-1] == t[i-1]) {
                    func_nums[i][j] = func_nums[i-1][j-1] + func_nums[i][j-1];
                }else {
                    func_nums[i][j] = func_nums[i][j-1];
                }
            }
        }
        return func_nums[n][m];
    }
};