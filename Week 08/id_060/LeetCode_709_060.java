/*
 709
  Implement function ToLowerCase() that has a string parameter str,
  and returns the same string in lowercase.

  Example 1:
    Input: "Hello"
    Output: "hello"

  Example 2:
    Input: "here"
    Output: "here"

  Example 3:
    Input: "LOVELY"
    Output: "lovely"
*/

public class ToLowerCase {

  public String toLowerCase(String str) {
    char[] charString = new char[str.length()];
    char c;
    for (int i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c >= 65 && c <= 90) {
        c = (char) (c + 32);
      }
      charString[i] = c;
    }
    return new String(charString);
  }
}
