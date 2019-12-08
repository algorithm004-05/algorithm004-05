# @author:leacoder
# @des:  DFS 扫雷游戏


'''
DFS
从点击处向四周DFS
递归 终止条件1 :
直接触雷 
递归 终止条件2 ：
board[row][col]四周有雷

'''

class Solution:
     # 便于 上下左右扩散
    dx = [-1, 1, 0, 0,-1,-1,1,1]
    dy = [ 0, 0,-1, 1,-1,1,-1,1]
    
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        max_x = len(board[0]) -1 # col
        max_y = len(board) -1 # row
        row = click[0]  # y
        col = click[1]  # x

        # 递归 终止条件1  
        if board[row][col] == "M":
            board[row][col] = "X"
            return board
        else:
            # 计算周边地雷数量
            count = 0
            for i in range(8):
                r = row + self.dy[i]
                c = col + self.dx[i]
                # 边界检测
                if r<0 or r > max_y or c<0 or c > max_x:
                    continue
                if board[r][c]=="M" or board[r][c]=="X":
                    count +=1
            # 递归 终止条件1  
            if count > 0:
                board[row][col] = str(count)
                return board
            else:
                board[row][col] = "B"
                for i in range(8):
                    r = row + self.dy[i]
                    c = col + self.dx[i]
                    # 边界检测
                    if r<0 or r > max_y or c<0 or c > max_x:
                        continue
                    if board[r][c]=="E": # 递归
                        self.updateBoard(board,[r,c])
                return board


