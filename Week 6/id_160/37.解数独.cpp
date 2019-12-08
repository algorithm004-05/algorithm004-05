/*
 * @lc app=leetcode.cn id=37 lang=cpp
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
public:
    // line, column, block 分别存储每行、每列、每宫中可用的数字
    vector<set<int>> line, column, block;
    
    //哈希更新每行/列/宫中可以使用的数字
    void update( vector<vector<char>>& board){
        set<int> compare = {1,2,3,4,5,6,7,8,9};
        //a 行；b 列；c 宫
        for( int i = 0; i < 9; i++)
            line.push_back( compare), column.push_back( compare), block.push_back( compare); 
        
        for( int i = 0; i < 9; i++)
            for( int j = 0; j < 9; j++)
                if( board[i][j] != '.'){
                    int t = board[i][j] - '0';
                    line[i].erase( t),  column[j].erase(t), block[i / 3 + j / 3 * 3].erase(t); 
                }
        
        return ;
    }
    
    //检查该位置处字符是否可以放到该处
    bool check( vector<vector<char>>& board, const int& i, const int& j, int num){
        if( line[i].find( num) != line[i].end()
         && column[j].find( num) != column[j].end()
         && block[i/3 + j/3*3].find( num) != block[i/3 + j/3*3].end())
            return true;
        return false;
    }
    
    //标记
    int flag = 0;
    
    //dfs + 回溯
    void dfs( vector<vector<char>>& board, int count){
        if( count == 81){
            flag = 1;
            return ;
        }
            

        int i = count / 9, j = count % 9;
        
        if( board[i][j] == '.'){
            //检查 1 ～ 9 中数字哪一个可以放入该位置
            for( int k = 1; k < 10; k++)
                if( check( board, i, j, k)){
                    line[i].erase( k), column[j].erase( k), block[ i /3 + j/3*3].erase( k);
                    
                    board[i][j] = k + '0';
                    dfs( board, count + 1);
                    
                    if( !flag){
                        line[i].insert( k), column[j].insert( k), block[ i /3 + j/3*3].insert( k);
                        board[i][j] = '.';
                    }
                    else
                        return ;
                }
        }
        else
            dfs( board, count + 1);
            
        return ;
    }
    
    void solveSudoku(vector<vector<char>>& board) {
        update( board);
        //show( line, column, block);
        dfs( board, 0);
    }
};
// @lc code=end

