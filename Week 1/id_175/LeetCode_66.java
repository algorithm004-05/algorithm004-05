/**
 * @Auther: shizeying
 * @Date: 19-10-20 20:22
 * @Description:
 */
public class LeetCode_66 {
	public int[] plusOne(int[] digits) {
		
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
