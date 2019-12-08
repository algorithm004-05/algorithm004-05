
class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        set<pair<int, int>> obstacles_set;
        for (auto obstacle : obstacles) {
            obstacles_set.insert(make_pair(obstacle[0], obstacle[1]));
        }
        
        vector<int> dx = {0, 1, 0, -1};
        vector<int> dy = {1, 0, -1, 0};
        int d_index = 0;
        int x=0, y=0;
        int ans = 0;
        for (auto command : commands) {
            if (command == -2) {
                d_index = (d_index+3)%4;
            } else if (command == -1) {
                d_index = (d_index+1)%4;
            } else {
                for (int i=0; i<command; ++i) {
                    auto xx = x + dx[d_index];
                    auto yy = y + dy[d_index];
                    if (obstacles_set.find(make_pair(xx, yy)) == obstacles_set.end()) {
                        x = xx;
                        y = yy;
                        ans = max(ans, x*x+y*y);
                    }
                }
            }
        }
        
        return ans;
        
    }
};