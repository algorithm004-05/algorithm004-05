# @author:leacoder 
# @des: Trie (前缀树，字典树)   单词搜索 II

# 将words存入 Trie 中，然后将board 中的字母 按顺序依次DFS 与 Trie 中字母比较 


class Trie: #辅助 Trie
    def __init__(self):
        self.root = {}
        self.endofword =  "#"

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            node = node.setdefault(char,{})
        node[self.endofword] = self.endofword
    
    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node.get(char)
        return self.endofword in node
    
    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node.get(char)
        return True


dx = [ 0, 0,-1, 1]
dy = [-1, 1, 0, 0,]
# 在board 中以当前位置（x0,y0） 上下左右的偏移量 ,上偏移(x0,y0-1) 下偏移（x0,y0+1） 左偏移（x0+1,y0） 右偏移（x0-1,y0）


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words:
            return []
        self.result = set() # 结果集合
        self.myTrie = Trie()    # 辅助字典树

        # 将words存入 辅助Trie 中
        for word in words:
            self.myTrie.insert(word)

        # 遍历board中字符
        self.max_y = len(board) # 行
        self.max_x = len(board[0])  # 列

        for y in range(self.max_y):
            for x in range(self.max_x):
                if board[y][x] in self.myTrie.root: # 首字符是否在字典树 root中
                    self._dfs(board,y,x,"",self.myTrie.root)    # dfs 四联通
        
        return list(self.result)

    def _dfs(self, board: List[List[str]], i: int, j: int, cur_word: str, cur_dict: dict)->None:
        cur_word += board[i][j]  # board[i][j] 必然已经搜索到 累加字符 成为当前 单词（单词前缀）
        cur_dict = cur_dict[board[i][j]]    # Trie树的下一层 某个word的下一字符 合集 字典

        # 递归终止条件
        if self.myTrie.endofword in cur_dict: # 是否已经探寻到Trie最后 也就是words中某个word 被找到
            self.result.add(cur_word)
            # 不能直接return，还是要继续，结果中 有包含关系的单词存在
            ''' 例如
            board: [["a","b"],["a","a"]]
            words: ["aba","baa","bab","aaab","aaa","aaaa","aaba"]
            retult:
            ["aaa","aaab","aaba","baa","aba"]
            '''
        # 当前递归层级处理
        tmp,board[i][j] = board[i][j],"@"  
        # 同一个单元格内的字母在一个单词中不允许被重复使用。
        #暂存 board[i][j]  用“@” 标记是否被访问过了   用于下面偏移

        # 四个方向的偏移递归
        for k in range(4):
            y ,x = i + dy[k], j + dx[k]
            # 边界判断
            if 0 <= x < self.max_x and 0 <= y < self.max_y:
                if board[y][x] !="@" and board[y][x] in cur_dict:
                    # 递归到下一层
                    self._dfs(board,y,x,cur_word,cur_dict)  # 深度优先继续搜索
        # 恢复当前层状态
        board[i][j] = tmp #循环结束 恢复以前数据 （board[i][j]之前被设置为"@"标记是否被访问过了）