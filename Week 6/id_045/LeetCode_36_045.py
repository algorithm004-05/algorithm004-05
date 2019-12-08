

'''
box_index = (row / 3) * 3 + columns / 3，其中 / 是整数除法。
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # 初始化
        rows = [{} for i in range(9)]   # 每一行 数值 0 -9 出现次数
        columns = [{} for i in range(9)]
        boxes = [{} for i in range(9)]

        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.': # 是否已有数值
                    num = int(num)
                    box_index = (i // 3 ) * 3 + j // 3  # 确定 小九宫格
                    # 填上已有数据
                    rows[i][num] = rows[i].get(num, 0) + 1
                    columns[j][num] = columns[j].get(num, 0) + 1
                    boxes[box_index][num] = boxes[box_index].get(num, 0) + 1

                    # 校验之前已有，是否合法
                    if rows[i][num] > 1 or columns[j][num] > 1 or boxes[box_index][num] > 1:
                        return False   
        return True

