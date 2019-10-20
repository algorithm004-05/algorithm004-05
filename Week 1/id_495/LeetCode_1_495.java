import java.util.HashMap;

public class LeetCode_1_495 {

  public static void main(String[] args) {
    int[] numbers = {4,3,7,23,10};
    int target = 30;
    int[] result = twoSum(numbers, target);
    for (int a: result) {
      System.out.print(a);
    }
  }

  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
  }
}
