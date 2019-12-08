class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        rows = static_cast<int>(grid.size());
        columns = static_cast<int>(grid[0].size());
        if (grid[0][0] == 1 || grid[rows-1][columns-1] == 1)
            return -1;
        queue<shared_ptr<Node>> q;
        q.push(make_shared<Node>(0, 0, 1));
        while(!q.empty()) {
            auto now = q.front();
            q.pop();
            if (now->x == rows-1 && now->y == columns-1)
                return now->step;
            
            for (int i=0; i<8; ++i) {
                int nx = now->x + dp[i][0];
                int ny = now->y + dp[i][1];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= columns || grid[nx][ny])
                    continue;
                grid[nx][ny] = 1;
                q.push(make_shared<Node>(nx, ny, now->step+1));
            }
        }
        return -1;
    }
    
private:
    struct Node{
        int x;
        int y;
        int step;
        Node(int x_, int y_, int step_) {
            x = x_;
            y = y_;
            step = step_;
        }
    };
    
    int rows;
    int columns;
    int dp[8][2] = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
        {1, 1},
        {-1, -1},
        {1, -1},
        {-1, 1}
    };
};




