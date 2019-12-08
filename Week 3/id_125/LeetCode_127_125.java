import java.util.*;

public class A127 {
    public static void main(String[] args) {
        A127 a127 = new A127();
        String b = "hit";
        String e = "cog";
        String[] arr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(arr);


//        System.out.println(a127.ladderLength1(b, e, wordList));
//        System.out.println(a127.ladderLength2(b, e, wordList));
        System.out.println(a127.ladderLength3(b, e, wordList));
    }

    /**
     * 第一版本
     * 思路：存在一个最近add word的set，每次存放与上一个单词最相近的数据。
     * 每次遍历这个set，并且从wordList中删除符合题目要求的单词（只差一个字母）
     * 把这些删除的单词汇总在一起，重新赋值给set。
     * 再重复遍历这个set。直到，某次没有删除单词，或者set中存在endWord为止
     * <p>
     * 该种每次遍历全部的只差一个字母的方式，属于广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);

        if (!wordDict.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int count = 1;
        while (!set.contains(endWord)) {
            Set<String> toAddWord = new HashSet<>();
            for (String setWord : set) {
                for (String word : wordDict) {
                    if (isDiffOne(setWord, word)) {
                        toAddWord.add(word);
                    }
                }
                wordDict.removeAll(toAddWord);
            }

            if (toAddWord.size() == 0) {
                return 0;
            }

            count++;
            set = toAddWord;
        }
        return count;
    }

    public boolean isDiffOne(String w1, String w2) {
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();

        int count = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    /**
     * 第2版本（第1版本上优化）
     * isDiffOne 所花费的时间过多，转而采用，替换set中，某个单词的第i位的每一个字母
     * 并且与字典中的数据进行对比。
     * <p>
     * 该种每次遍历全部的只差一个字母的方式，属于广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);

        if (!wordDict.contains(endWord)) {
            return 0;
        }

        // 加入首单词
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int count = 1;

        // 如果上次相近的单词中存在end，那么退出
        while (!set.contains(endWord)) {
            Set<String> toAddWord = new HashSet<>();

            // 从set中，查找符合条件的数据
            for (String setWord : set) {

                for (int i = 0; i < setWord.length(); i++) {
                    char[] chars = setWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (wordDict.contains(newWord)) {
                            toAddWord.add(newWord);
                        }
                    }
                }
                // 从字典中删除数据，避免第二次循环。以及后续循环再次访问到
                wordDict.removeAll(toAddWord);
            }

            // 如果没有搜索，没有发现符合条件的数据，那么就可以结束了
            if (toAddWord.size() == 0) {
                return 0;
            }
            // 次数++
            count++;
            // 把这些数据重新赋值给set，目的是为了用这些数据下次寻找字典中相似的数据
            set = toAddWord;
        }
        return count;
    }

    /**
     * 第三版本
     * 递归
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.remove(endWord);
        Queue<String> queue = new LinkedList<String>();
        char[] beginWordCharArray = beginWord.toCharArray();
        char[] charArray = endWord.toCharArray();
        int b = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == beginWordCharArray[i]) {
                ++b;
            }
        }
        if (b + 1 == charArray.length) {
            return 2;
        }
        queue.offer(endWord);
        int d = 3;
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if ("@".equals(poll)) {
                ++d;
                continue;
            }
            char[] charArray3 = poll.toCharArray();
            Iterator<String> iterator1 = wordList.iterator();
            while (iterator1.hasNext()) {
                String next = iterator1.next();
                char[] charArray2 = next.toCharArray();
                int a = 0;
                for (int i = 0; i < charArray2.length; i++) {
                    if (charArray3[i] == charArray2[i]) {
                        ++a;
                    }
                }
                if (a + 1 == charArray3.length) {
                    int c = 0;
                    for (int i = 0; i < charArray2.length; i++) {
                        if (charArray2[i] == beginWordCharArray[i]) {
                            ++c;
                        }

                    }
                    if (c + 1 == charArray2.length) {
                        return ++d;
                    }
                    queue.offer(next);
                    iterator1.remove();
                }
            }
            queue.offer("@");
        }
        return 0;
    }

    /**
     * 第三版本
     * 递归
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        //hashset的好处：去重也完成了
        //开始端
        HashSet<String> start = new HashSet<>();
        //结束端
        HashSet<String> end = new HashSet<>();
        //所有字符串的字典
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) return 0;
        //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
        return bfs(start, end, dic, 2);

    }

    public int bfs(Set<String> st, Set<String> ed, HashSet<String> dic, int l) {

        if (st.size() == 0) {
            return 0;
        }

        if (st.size() > ed.size()) {
            return bfs(ed, st, dic, l);
        }

        Set<String> toAddSet = new HashSet<>();

        for (String s : st) {

            for (int i = 0; i < s.length(); i++) {

                char[] chars = s.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newString = new String(chars);

                    if (ed.contains(newString)) {
                        return l;
                    }

                    if (dic.contains(newString)) {
                        toAddSet.add(newString);
                    }
                }
            }

            dic.removeAll(toAddSet);
        }
        st = toAddSet;
        return bfs(st, ed, dic, l + 1);
    }

}
