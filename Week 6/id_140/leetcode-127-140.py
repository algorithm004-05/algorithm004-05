from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        L = len(beginWord)
        #创建叫all...字典
        all_combo_dict = defaultdict(list)  
        #遍历列表的单词
        for word in wordList:
        #循环一个单词的长度 从0开始              
            for i in range(L):             
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)  #一次{'h*t':[hot]} 两次{'*ot':[hot]}
        
         # Queue for BFS
        queue = [(beginWord, 1)]
        visited = {beginWord: True}
        while queue:
            #取出队列中第一个元素
            current_word, level = queue.pop(0) 
            #循环一个单词长度
            for i in range(L):                 
                inter_word = current_word[:i] + "*" + current_word[i+1:]
                #将一个单词（例*it h*t hi*）对应的单词遍历到word
                for word in all_combo_dict[inter_word]: 
                    if word == endWord:
                        return level + 1
                    #当word不等于endWord时
                    if word not in visited:  
                        visited[word] = True
                        queue.append((word, level + 1))
                #上一步for循环之后将*单词对应的 单词改为[]
                all_combo_dict[inter_word] = []  
        
        return 0