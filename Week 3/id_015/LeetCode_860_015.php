class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $five = 0;
        $ten = 0;

        for ($i = 0; $i < count($bills); $i++) {
            if ($bills[$i] == 5) {
                $five++;
            } elseif ($bills[$i] == 10) {
                $five--;
                $ten++;
            } else {
                if ($ten > 0) {
                    $ten--;
                    $five--;
                } else {
                    $five -= 3;
                }
            }

            if ($five < 0) {
                return false;
            }
        }
        return true;
    }
}
