# NOTE

### 关于有效的字母异位词的思考

这道题很久之前做过了，看了自己的代码觉得写的太过啰嗦，但也没有想出更好的方法来。看了题解无非就是哈希计数和排序两种方法，看 PHP 的最优解时惊讶的发现原来还有 `count_chars() - 返回字符串所用字符的信息` 这样的函数（好奇弄这个函数是为了干啥），然后看了 Java 的最优解时第一时间没能看懂代码前半部分的用意，显然这个解法用的也是哈希计数的方式，这样的方法能够达到 0ms 的时间，可当我去掉前面我看不懂用意的判断重新提交代码时，时间显然变成了 8ms。（这是用来对抗题解的测试用例么？）
````
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        // 让我百思不得其解的判断 为什么要特地检查这个前缀？
        if (s.startsWith("hhby")) {
            return true;
        }
        // 以及这条哪里来的判断
        if (s.length() > 500) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
````
当我把这样的代码写进 PHP 里面之后才发现，这个大哥真的是照着题目的测试用例来的。。。。。。

