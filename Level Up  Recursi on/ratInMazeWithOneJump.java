public class ratInMazeWithOneJump {
      public static int ratInMaze(int sr, int sc, int[][] board, String[] dirS, int[][] dir, String ans) {
            int n = board.length;
            int m = board[0].length;
            if (sr == n - 1 && sc == m - 1) {
                  System.out.println(ans);
                  return 1;
            }
            
            board[sr][sc] = 0;// Block
            int count = 0;
            for (int d = 0; d < dir.length; d++) {
                  int r = sr + dir[d][0];
                  int c = sc + dir[d][1];

                  if (r >= 0 && c >= 0 && r < n && c < m) {
                        if (board[r][c] == 1)
                              count += ratInMaze(r, c, board, dirS, dir, ans + dirS[d]);
                  }                 
            }
            board[sr][sc] = 1;// free
            return count;
      }

      public static void main(String[] args) {
            int[][] board = { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
            String[] dirS = { "U", "R", "L", "D" };
            int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
            System.out.println(ratInMaze(0, 0, board, dirS, dir, ""));
      }  
}
