import java.util.*;

class LeetCode_529_495 {
    """
    扫雷游戏
    """
    
    private static int[] dx = new int[]{0,0,1,-1,1,1,-1,-1};
    private static int[] dy = new int[]{1,-1,0,0,1,-1,1,-1};

    public static void main(String[] args) {
        char[][] board = new char[][] {
            new char[] {'M','E','E','E','E'},
            new char[] {'E','E','E','M','E'},
            new char[] {'E','E','M','E','E'},
            new char[] {'E','E','E','E','E'},
        };
        int[] click = new int[] {3,0};
        char[][] result = new LeetCode_529_495().updateBoard(board, click);
        for(char[] a: result) {
            System.out.println(Arrays.toString(a));
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {

  	    if(click.length == 0) return board;
	      int begin = click[0];
	      int end = click[1];
	      boolean[][] visited = new boolean[board.length][board[0].length];
	      if(board[begin][end] == 'M') {
		        board[begin][end] = 'X';
		        return board;
	      }
	      dfsboard(board,begin,end,visited);
	      return board;
    }

    public boolean check(char[][] board,int x,int y) {
      	if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
        		return true;
      	}
      	return false;
    }

    public void dfsboard(char[][] board,int begin,int end,boolean[][] visited) {
  	    int numM = 0;
	      visited[begin][end] = true;
	      for(int i = 0;i < 8;i++) {
		        int x = begin + dx[i];
		        int y = end + dy[i];
		        if(check(board,x,y) && (board[x][y] == 'M' || board[x][y] == 'X')) {
			          numM++;
		        }
	      }
	      if(numM > 0) {
		        String str = numM + "";
		        board[begin][end] = str.charAt(0);
	      }else {
		        board[begin][end] = 'B';
		        for(int j = 0;j < 8;j++) {
			          int x = begin + dx[j];
			          int y = end + dy[j];
			          if(check(board,x,y) && !visited[x][y] && board[x][y] == 'E')
			          dfsboard(board,x,y,visited);
		        }
	      }
	      visited[begin][end] = false;
    }
}
