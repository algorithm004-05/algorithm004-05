class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index_cookie = s.length - 1, index_child = g.length - 1;
        int count = 0;
        while (index_cookie >= 0 && index_child >= 0){
            if(s[index_cookie] >= g[index_child]){
                ++count;
                --index_cookie;
            }
            --index_child;
        }
        return count;
    }
}