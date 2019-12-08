<?php

class Solution
{

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return String[][]
     */
    function findLadders($beginWord, $endWord, $wordList)
    {
        if (!in_array($endWord, $wordList)) return [];
        $step = 0;
        $return = [];

        $s1[] = $beginWord;
        $list = array_flip($wordList);

        $wordLen = strlen($beginWord);

        $sendWordList = [];
        while (!empty($s1)) {

            foreach ($s1 as $word) {
                for ($i = 0; $i < $wordLen; $i++) {
                    $wordNew = $word;
                    for ($ch = ord('a'); $ch <= ord('z'); $ch++) {
                        $wordNew[$i] = chr($ch);
                        if ($wordNew == $endWord) {
                            $s[] = $wordNew;
                            $return[$step] = $s;
                            $s = [];
                            ++$step;
                            $s1[] = $beginWord;
                            $list = array_flip($wordList);
                            $sendList = array_flip($sendWordList);
                            $list = array_diff($sendList, $list);
                            break;
                        }
                        if (!array_key_exists($wordNew, $list)) continue;
                        if ($wordNew == $beginWord) {
                            $sendWordList[] = $wordNew;
                        }
                        unset($list[$wordNew]);
                        $s[] = $wordNew;
                    }
                }
            }

            $s1 = $s;
            $return[$step] = $s;
        }
        return [];
    }
}

$beginWord = "hit";
$endWord = "cog";
$wordList = ["hot", "dot", "dog", "lot", "log", "cog"];

$c = new Solution();
print_r($c->findLadders($beginWord, $endWord, $wordList));