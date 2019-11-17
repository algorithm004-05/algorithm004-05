class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gnum = 0, snum = 0;
        while(gnum<g.length &&snum<s.length) {
            if(g[gnum]<=s[snum]) {
                gnum++;
            }
            snum++;
        }
        return gnum;
    }
}