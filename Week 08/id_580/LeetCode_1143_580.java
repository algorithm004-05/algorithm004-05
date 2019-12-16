class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        m++;
        n++;
        int[] arr = new int[n];
        char[] arr1 = ("#" + text1).toCharArray();
        char[] arr2 = ("#" + text2).toCharArray();
        int temp;
        int now;
        for (int i = 1; i < m; i++) {
            temp = 0;
            for (int j = 1; j < n; j++) {
                now = arr[j];
                if (arr1[i] == arr2[j]) {
                    arr[j] = temp + 1;
                } else {
                    arr[j] = Math.max(arr[j - 1], arr[j]);
                }
                temp = now;
            }
        }
        return arr[n - 1];
    }
}
