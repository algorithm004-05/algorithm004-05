public class LeetCode_66_105 {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int value = digits[i] + 1;
            if(value >= 10){
                carry = value / 10;
                digits[i] = value % 10;
            }else{
                digits[i] = value;
                carry = 0;
                break;
            }
        }
        if(carry > 0){
            int[] nums = new int[digits.length + 1];
            nums[0] = carry;
            System.arraycopy(digits, 0, nums, 1, digits.length);
            return nums;
        }
        return digits;
    }
}
