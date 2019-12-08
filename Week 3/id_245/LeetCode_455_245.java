public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        for(int i=0,j=0; i<g.length && j<s.length;){
            if(g[i]<=s[j]){
                i++;
                j++;
                ret++;
            }else{
                j++;
            }
        }
        return ret;
    }
