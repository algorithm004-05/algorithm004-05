class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] mapRow = new HashMap[9];
        HashMap<Integer, Integer>[] mapColumn = new HashMap[9];
        HashMap<Integer, Integer>[] mapBox = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            mapRow[i] = new HashMap<>();
            mapColumn[i] = new HashMap<>();
            mapBox[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int n = (int) c;
                int box = i / 3 * 3 + j / 3;

                mapRow[i].put(n, mapRow[i].getOrDefault(n, 0) + 1);
                mapColumn[j].put(n, mapColumn[j].getOrDefault(n, 0) + 1);
                mapBox[box].put(n, mapBox[box].getOrDefault(n, 0) + 1);


                if (mapRow[i].get(n) >1 || mapColumn[j].get(n) >1 || mapBox[box].get(n) >1){
                    return false;
                }

            }
        }

        return true;
    }
}