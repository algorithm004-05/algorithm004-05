class Solution {
    public int numDistinct(String S, String T) {

        int[][] mem = new int[T.length()+1][S.length()+1];


        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }



        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }
}
