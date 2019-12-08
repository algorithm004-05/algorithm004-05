class Solution {
    
   var sortedDic = [String:Int]()
   var visted = [String:[String]]()
   var wordCounts = 0
   var checkWordList = [String]()
   var checkBeginWord = ""

   func ladderLength(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {
        if !wordList.contains(endWord) {
            return 0
        }
        self.checkBeginWord = beginWord
        self.checkWordList = wordList
        var charArry = [String]()
        for char in beginWord {
            charArry.append(String(char))
        }
        self.visted[beginWord] = charArry
        wordCounts = charArry.count
       
       if wordCounts == 1 {
           return 2
       }
       if wordList.count == 2 {
           let currlevel = 1
           getNextModeArry(beginWord,endWord,currlevel)
           return self.sortedDic[beginWord] ?? 0

       }
       
        for (i,item) in self.checkWordList.enumerated() {
            var charArry = [String]()
            for char in item {
                charArry.append(String(char))
            }
            self.visted[item] = charArry
        }

        let currlevel = 1
        checkArry(beginWord,endWord,currlevel)
        return self.sortedDic[beginWord] ?? 0
    }
      
    func getNextModeArry(_ checkItem: String, _ endWord: String, _ currlevel: Int) -> [String] {
         var nextModeArry = [String]()
         for (i,item) in self.checkWordList.enumerated() {
             if self.sortedDic[item] != nil {
                 continue
             }
            var noMatchTimesCheck = 0
            for i in 0 ... (self.wordCounts-1) {
                if let checks = self.visted[checkItem] as? [String], 
                let currs = self.visted[item] as? [String] {
                 if currs[i] != checks[i] {
                    noMatchTimesCheck += 1
                 }
                }
            }
            if noMatchTimesCheck == 1 {
                nextModeArry.append(item)
            }
         }

         if nextModeArry.contains(endWord) {
            let nextlevel = currlevel + 1
             if let currNum = sortedDic[checkBeginWord] {
                sortedDic[checkBeginWord] = currNum > nextlevel ? nextlevel : currNum
             } else {
                sortedDic[checkBeginWord] = nextlevel
             }
          }
        return nextModeArry
    }
    
    func checkArry(_ checkItem: String, _ endWord: String, _ level: Int) {
        var currlevel = level
        let nextModeArry = getNextModeArry(checkItem, endWord, currlevel)
        if currlevel == 1 && nextModeArry.isEmpty {
            return
        }
        var currCheckNextModeArry = [String]()
        currCheckNextModeArry.append(contentsOf:nextModeArry)
        var currCheckNextModeDic = [Int:[String]]()
        currCheckNextModeDic[currlevel] = currCheckNextModeArry
        while sortedDic.count < checkWordList.count {
            currlevel += 1
            for nextMode in currCheckNextModeArry where nextMode != checkBeginWord {
              sortedDic[nextMode] = currlevel
              let newNextModeArry = getNextModeArry(nextMode,endWord,currlevel)
              currCheckNextModeDic[currlevel] = currCheckNextModeDic[currlevel] == nil ? newNextModeArry : currCheckNextModeDic[currlevel]! + newNextModeArry
            }
            if sortedDic[checkBeginWord] == nil {
              currCheckNextModeArry.removeAll()
              currCheckNextModeArry.append(contentsOf:currCheckNextModeDic[currlevel] ?? [])
            } else {
                break
            }
        }

    }
}