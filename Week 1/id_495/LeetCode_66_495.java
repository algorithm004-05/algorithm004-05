public class LeetCode_66_495 {

  public static void main(String[] args) {
    int[] digits = {3,4,9,9,9};
    int[] result = plusOne(digits);
    for (int a: result) {
      System.out.println(a);
    }
  }

  public static int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
  }
}
