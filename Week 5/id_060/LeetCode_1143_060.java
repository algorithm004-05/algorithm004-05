/*
  1143
  Given two strings text1 and text2, return the length of their longest common subsequence.

  A subsequence of a string is a new string generated from the original string with some characters
  (can be none) deleted without changing the relative order of the remaining characters.
  (eg, "ace" is a subsequence of "abcde" while "aec" is not). 

  A common subsequence of two strings is a subsequence that is common to both strings.

  If there is no common subsequence, return 0.

  Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3

  Explanation:
    The longest common subsequence is "ace" and its length is 3.

  Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3

  Explanation:
    The longest common subsequence is "abc" and its length is 3.

  Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0

  Explanation:
    There is no such common subsequence, so the result is 0.

  Constraints:
    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.
*/

public class LongestCommonSubsequences {

  public int longestCommonSubsequence0(String text1, String text2) {
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    return longestCommonSubsequence0Helper(s1, s2, s1.length, s2.length);
  }

  public int longestCommonSubsequence0Helper(char[] text1, char[] text2, int i, int j) {
    if (i <= 0 || j <= 0) {
      return 0;
    }
    if (text1[i - 1] == text2[j - 1]) {
      return 1 + longestCommonSubsequence0Helper(text1, text2, i - 1, j - 1);
    } else {
      return Math.max(longestCommonSubsequence0Helper(text1, text2, i, j - 1), longestCommonSubsequence0Helper(text1, text2, i - 1, j));
    }
  }

  public int longestCommonSubsequence1(String text1, String text2) {
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    int[][] DP = new int[s1.length + 1][s2.length + 1];
    return longestCommonSubsequence1Helper(s1, s2, s1.length, s2.length, DP);
  }

  public int longestCommonSubsequence1Helper(char[] text1, char[] text2, int i, int j, int[][] DP) {
    if (i <= 0 || j <= 0) {
      return 0;
    }

    if (DP[i][j] != 0) {
      return DP[i][j];
    }

    if (text1[i - 1] == text2[j - 1]) {
      return 1 + longestCommonSubsequence1Helper(text1, text2, i - 1, j - 1, DP);
    } else {
      return DP[i][j] = Math.max(longestCommonSubsequence1Helper(text1, text2, i, j - 1, DP), longestCommonSubsequence1Helper(text1, text2, i - 1, j, DP));
    }
  }

  public int longestCommonSubsequence2(String text1, String text2) {
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    int[][] DP = new int[s1.length + 1][s2.length + 1];

    for (int i = 1; i < s1.length + 1; i++) {
      for (int j = 1; j < s2.length + 1; j++) {
        if (s1[i - 1] == s2[j - 1]) {
          DP[i][j] = DP[i - 1][j - 1] + 1;
        } else {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
        }
      }
    }

    return DP[s1.length][s2.length];
  }

  public int longCommonSubsequence3(String text1, String text2) {
    if (text1.length() > text2.length()) {
      String temp = text1;
      text1 = text2;
      text2 = temp;
    }

    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();
    int[] DP = new int[Math.max(s1.length, s2.length) + 1];

    for (int i = 1; i < s1.length + 1; i++) {
      int preDiagonalElement = 0;

      for (int j = 1; j < s2.length + 1; j++) {
        int tempPreDiagonalElement = DP[j];

        if (s1[i - 1] == s2[j - 1]) {
          DP[j] = preDiagonalElement + 1;
        } else {
          DP[j] = Math.max(DP[j], DP[j - 1]);
        }

        preDiagonalElement = tempPreDiagonalElement;
      }
    }

    return DP[Math.max(s1.length, s2.length)];
  }
}
