//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。 
//
// 示例: 
//
// 
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 要求: 
//
// 
// 该字符串只包含小写的英文字母。 
// 给定字符串的长度和 k 在[1, 10000]范围内。 
// 
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] s_array = s.toCharArray();
        for (int start = 0;start < s_array.length;start+=2*k){
            // 设定初始值，隔K个字符进行反转。
            int i = start;
            // 根据规则，剩余的尾巴若小于k，则全部反转。
            int j = Math.min(start + k - 1, s_array.length - 1);
            while (i<j){
                char tmp =s_array[i];
                s_array[i++]= s_array[j];
                s_array[j--]= tmp;
            }
        }
        return new String(s_array);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
