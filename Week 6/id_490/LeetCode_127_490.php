<?php
/**
 * 题目名称：word-ladder 单词接龙
 * 题目链接：https://leetcode-cn.com/problems/word-ladder/
 */

class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList) {
        $visited = [$beginWord];
        $queue = [$beginWord];
        $len = 1;

        while (!empty($queue)) {
            $word = array_pop($queue);
            $wordArr = str_split($word);
            for ($i = 0; $i < count($wordArr); $i++) {
                for ($j = ord('a'); $j <= ord('z'); $j++) {
                    if (chr($j) == $wordArr[$i]) continue;
                    $old = $wordArr[$i];
                    $wordArr[$i] = chr($j);
                    $newWord = implode('', $wordArr);
                    if (in_array($newWord, $wordList) && $newWord == $endWord) {
                        return $len + 1;
                    }
                    
                    if (in_array($newWord, $wordList) && !in_array($newWord, $visited)) {
                        echo $newWord . '-' . $len . "\r\n";
                        array_push($visited, $newWord);
                        array_push($queue, $newWord);
                    }
                    $wordArr[$i] = $old;
                }
            }
            
            $len++;
        }

        return 0;
    }
}