import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start

//双向bfs并不是从两端同时bfs, 实际上是这次从begin进行bfs, 下次从end进行bfs, 像这样循环操作(实际上是选择最小的端进行扩散)
class Solution {
    public int ladderLength(String beginWord, String endWord, 
                            List<String> wordList__) {
        // 方法一，超哥课上代码，双向BFS
        
        // 用Set代替Queue进行BFS，为了进行更便捷查询单词是否在wordList里面
        // 如果不用哈希，直接的list的查询时间复杂度是O(n)，用了哈希后为O(1)

        // 把List放入到HashSet中，后面访问元素的时候用O（1）复杂度
        if (!wordList__.contains(endWord)) return 0;
        
        // 把wordList__转换为Set，方便后面的比较操作
        Set<String> wordList = new HashSet<>(wordList__);

        // beginSet是从beginWord开始扩散的，endSet是从endWord开始扩散的
        Set<String> beginSet = new HashSet<>(),
                    endSet = new HashSet<>();

        // 转换的次数，这是细节，由于beginWord!=endWord, 所以至少需要一步变化
        int len = 1;
        // visited表示这个BFS节点是否已经被访问过了。
        HashSet<String> visited = new HashSet<>();

        // 这里和单向BFS中一开始往queue中加入元素的操作类似，加入初始元素
        //可以看出，beginSet和endSet本质没有先后顺序，先扩散量小的可以更快收敛
        beginSet.add(beginWord);
        endSet.add(endWord);

        //BFS start here
        while( !beginSet.isEmpty() ) {
            // 扩散的时候优先选择小的Set。
            //如果beginSet更小，就扩散它。
            //否则如果beginSet更大，交换这两个Set，还是从小的Set开始扩散
            //核心:控制当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            // neighbor这个set表示每一次要扩散的set的内容
            Set<String> neighbor = new HashSet<>();
            // 这里的HashSet和模板的queue是一样的含义，只是更方便查找
            for (String word : beginSet) {
                //对每一个单词，变化它的字符位
                char[] chs = word.toCharArray();
                //用字母表遍历当前chs的每一个字母
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a' ; c <= 'z'; c++) {
                        // 保存chs的当前位置的字母
                        char old = chs[i];
                        // 然后替换成当前遍历到的字母表的字母
                        chs[i] = c;
                        //转换回String，从而使用endSet中的contains方法
                        //否则不能对char[]使用contains方法
                        String target = String.valueOf(chs);

                        //因为endSet是从endWord那边扩散过来的，如果我们替换过程中产生的target也在
                        //这个set里面，说明从begin扩散过来的Set和从end扩散过来的set 在这里相交了
                        //这个相交的word就是target
                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        //如果当时没找到target，则继续扩散其他的target，且把target加到下一次
                        //要扩散的set里面去 ，这里的neighbor set就是后面要扩散的set
                        if (!visited.contains(target) && wordList.contains(target)) {
                            neighbor.add(target);
                            //标记target为visited，表示访问过了
                            visited.add(target);
                        }
                        // 把单词本身还原
                        chs[i] = old;
                    }
                }
            }
            // 处理完begin中的元素后, 让begin指向begin中的元素的邻居
            beginSet = neighbor;
            //路径长度++
            len ++;
        }
        //没有转换的路径
        return 0;
    }
}
// @lc code=end

