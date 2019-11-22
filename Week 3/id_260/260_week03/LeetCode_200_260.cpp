#include <vector>
using namespace std;
class Solution {
    private:
    int rows;
    int cols;
    void dfs(vector<vector<char>>& grid,int row,int col){
        grid[row][col]='0';
        if(row-1>=0&&grid[row-1][col]=='1')dfs(grid,row-1,col);
        if(row+1<rows&&grid[row+1][col]=='1')dfs(grid,row+1,col);
        if(col-1>=0 && grid[row][col-1]=='1')dfs(grid,row,col-1);
        if(col+1<cols&& grid[row][col+1]=='1')dfs(grid,row,col+1);
    }
public:
    int numIslands(vector<vector<char>>& grid) {
         rows=grid.size();
        if (rows==0) return 0;
         cols=grid[0].size();
        int numsIslands=0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j]=='1')
                {
                    ++numsIslands;
                    dfs(grid,i,j);
                }

            }

        }
        return numsIslands;

    }
};