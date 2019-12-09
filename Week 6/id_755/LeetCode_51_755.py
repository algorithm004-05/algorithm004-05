# solution 1
# add possible col position to pos_lst inside dfs function
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return []
        def dfs(pos_lst):
            if len(pos_lst) == n:
                res_lst.append(pos_lst)
            for col_pos in range(n):
                if valid_pos(col_pos, pos_lst):
                    # only need to add the possible col_pos to set
                    # pos_lst will append col_pos inside dfs function
                    colpos_set.add(col_pos)
                    dfs(pos_lst+[col_pos])
                    # remove the previous col_pos from colpos_set
                    colpos_set.remove(col_pos)
        def valid_pos(col_pos, pos_lst):
            if col_pos in colpos_set:
                return False
            row_pos = len(pos_lst)
            for row, col in enumerate(pos_lst):
                if row - col == row_pos - col_pos or row + col == row_pos + col_pos:
                    return False
            return True
        def gen_board(res_lst):
            return [ [ "."*col_index + "Q" + "."*(n-col_index-1) for col_index in pos_lst] for pos_lst in res_lst]
        res_lst = []
        colpos_set = set()
        dfs([])
        return gen_board(res_lst)
    
# solution 2
# add results outside the dfs function
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return []
        def dfs(pos_lst):
            if len(pos_lst) == n:
                # a copy of current solution pos_lst is appended to res_lst
                # if use pos_lst and n == 4, the final result is [[],[]]
                res_lst.append(pos_lst[:])
                return
            for col_pos in range(n):
                if valid_pos(col_pos, pos_lst):
                    colpos_set.add(col_pos)
                    # append col_pos outside the dfs function
                    pos_lst.append(col_pos)
                    dfs(pos_lst)
                    # remove col_pos from pos_lst
                    # because col_pos in pos_lst are unique (determined by previous if valid_pos(col_pos, pos_lst), 
                    # we can use remove function here)
                    # if the element in list is non-unique, 
                    # remove function will remove the first (defined by index) shown-up element
                    pos_lst.remove(col_pos)
                    colpos_set.remove(col_pos)
        def valid_pos(col_pos, pos_lst):
            if col_pos in colpos_set:
                return False
            row_pos = len(pos_lst)
            for row, col in enumerate(pos_lst):
                if row + col == row_pos + col_pos or row - col == row_pos - col_pos:
                    return False
            return True
        def gen_board(res_lst):
            return [[ "."*col_pos + "Q" + "."*(n-col_pos-1) for col_pos in pos_lst] for pos_lst in res_lst]
        res_lst = []
        colpos_set = set()
        dfs([])
        return gen_board(res_lst)