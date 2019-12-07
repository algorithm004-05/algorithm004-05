/**
 * 题目名称：to-lower-case 转换成小写字母
 * 题目链接：https://leetcode-cn.com/problems/to-lower-case/
 */
class Solution {
    // 暴力求解
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int groups = arr.length / (2 * k);
        int rest = arr.length % (2 * k);
        for (int i = 0; i < groups; i++) {
            int left = 2 * k * i;
            int right = left + k - 1;
            while (left <= right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        int left = groups * 2 * k;
        int right = rest <= k ? left + rest - 1 :  left + k - 1;
        
        while (left <= right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return new String(arr, 0, arr.length);
    }

    // leetcode官方题解更简洁的写法
    public String reverseStr2(String s, int k) {
        char[] arr = s.toCharArray();
        for (int start = 0; start < s.length(); start += 2 * k) {
            int left = start, right = Math.min(left + k - 1, s.length() - 1);
            while (left <= right) {
                char tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }
   
        return new String(arr);
    }
}