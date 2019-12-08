class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ret;
        if(intervals.size() == 0)
            return ret;
        sort(intervals.begin(), intervals.end());
        for (int i = 0; i < intervals.size(); )
        {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.size() - 1 && right >= intervals[i+1][0]) {
                i++;
                right = max(right, intervals[i][1]);
            }
            ret.push_back({left, right});
            i++;
        }
        return ret;
    }
};
