class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        if endWord not in wordList: return 0
        if beginWord in wordList: wordList.remove(beginWord)
        ans=[1,1]
        A=[1]
        m=len(beginWord)
        letters= set('qwertyuioplkjhgfdsazxcvbnm')
        def backtrack(forward,wordList):
            if not forward:
                A.remove(1)
                return
            cur=set()
            for word in forward:             
                for idx in range(m):
                    x,y = word[:idx],word[idx+1:]
                    for letter in letters:
                        temp = x + letter + y
                        if temp ==endWord: return len(ans)
                        if temp in wordList:                           
                            cur.add(temp)
                            wordList.remove(temp)
            ans.append(1)        
            backtrack(cur,wordList)
        backtrack({beginWord},wordList)
        if not A:
            return 0     
        return len(ans)