package com.geek.lee.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */

/**
 * 126.单词接龙II
 */
public class FindLadders_126 {

    private int curSize = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 定义返回结果集
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        temp.add(beginWord);
        dfsFindLadders(beginWord, endWord, wordList, temp, res);
        return res;
    }


    private void dfsFindLadders(String beginWord, String endWord, List<String> wordList, List<String> temp, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            if (curSize > temp.size()) {
                res.clear();
                curSize = temp.size();
                res.add(new ArrayList<>(temp));
            } else if (curSize == temp.size()) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (temp.size() > curSize) {
            return;
        }

        for (int i = 0; i < wordList.size(); i ++) {
            String curWord = wordList.get(i);
            if (temp.contains(curWord)) {
                continue;
            }
            if (oneChanged(beginWord, curWord)) {
                temp.add(curWord);
                dfsFindLadders(curWord, endWord, wordList, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean oneChanged(String beginWord, String curWord) {
        int count = 0;
        for (int i = 0; i <beginWord.length(); i ++) {
            if (beginWord.charAt(i) != curWord.charAt(i)) {
                count ++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(new FindLadders_126().findLadders("hit", "cog", wordList));
    }
}
