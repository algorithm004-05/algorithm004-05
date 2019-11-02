<?php


class Solution
{
    /**
     * 执行用时 :16 ms, 在所有 php 提交中击败了75.24%的用户
     * 依旧是用哈希计数，以下是看题解的方式
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    public function isAnagramHashCount($s, $t)
    {
        if (strlen($s) !== strlen($t)) {
            return false;
        }

        $hash = [];
        for ($i = 0; $i < strlen($s); $i++) {
            if (!isset($hash[$s[$i]])) {
                $hash[$s[$i]] = 0;
            }
            if (!isset($hash[$t[$i]])) {
                $hash[$t[$i]] = 0;
            }
            $hash[$s[$i]]++;
            $hash[$t[$i]]--;
        };

        foreach ($hash as $value) {
            if ($value) {
                return false;
            }
        }

        return true;
    }

    /**
     * 本宝宝两个月之前的代码
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    public function isAnagram($s, $t)
    {
        if (strlen($s) != strlen($t)) {
            return false;
        }
        // 哈希计数
        $hash = [];
        for ($i = 0; $i < strlen($s); $i++) {
            if (!isset($hash[$s[$i]])) {
                $hash[$s[$i]] = 1;
            } else {
                $hash[$s[$i]] += 1;
            }
        }

        for ($i = 0; $i < strlen($s); $i++) {
            if (!isset($hash[$t[$i]])) {
                return false;
            } elseif ($hash[$t[$i]] > 1) {
                $hash[$t[$i]] -= 1;
            } elseif ($hash[$t[$i]] == 1) {
                unset($hash[$t[$i]]);
            }
        }
        return true;
    }
}
