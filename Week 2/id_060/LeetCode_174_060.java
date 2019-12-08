/*
  174
  Given a string containing digits from 2-9 inclusive,
  return all possible letter combinations that the number could represent.

  A mapping of digit to letters (just like on the telephone buttons) is given below.
  Note that 1 does not map to any letters.

  Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

  Note:
    Although the above answer is in lexicographical order,
    your answer could be in any order you want.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }

    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    List<String> result = new ArrayList<>();
    search(digits,map, result, "", 0);
    return result;
  }

  private void search(String digits, Map<Character, String> map, List<String> result, String string, int starter) {

    // Terminator
    if (starter == digits.length()) {
      result.add(string);
      return;
    }

    // Process
    String letters = map.get(digits.charAt(starter));
    for (int i = 0; i < letters.length(); i++) {
      search(digits, map, result, string + letters.charAt(i), i + 1);
    }
  }

  // TODO BFS Queue
}
