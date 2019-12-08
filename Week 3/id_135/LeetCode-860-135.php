<?php

class Solution
{

    private $five = 0;

    private $ten = 0;

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills)
    {
        foreach ($bills as $bill) {
            if ($bill == 5) {
                ++$this->five;
            } else if ($bill == 10) {
                if ($this->five > 0) {
                    --$this->five;
                } else {
                    return false;
                }
                ++$this->ten;
            } else {
                if ($this->ten > 0 && $this->five > 0) {
                    --$this->ten;
                    --$this->five;
                } else if ($this->five >= 3) {
                    $this->five = $this->five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}