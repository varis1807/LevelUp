import java.util.ArrayList;

public class SudokuBits {
      public class pair {
            int r = 0;
            int c = 0;

            pair(int r, int c) {
                  this.r = r;
                  this.c = c;
            }
      }

      public static int[] rows, cols;
      public static int[][] mat;
  
      public boolean solveSudokuBits(char[][] board, int idx, ArrayList<pair> arr) {
          if (idx == arr.size()) {
              return true;
          }
  
          pair p = arr.get(idx);
          int r = p.r;
          int c = p.c;
  
          for (int num = 1; num <= 9; num++) {
              int mask = (1 << num);
              if ((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                  board[r][c] = (char) (num + '0');
                  rows[r] ^= mask;
                  cols[c] ^= mask;
                  mat[r / 3][c / 3] ^= mask;
  
                  if (solveSudokuBits(board, idx + 1, arr))
                      return true;
  
                  board[r][c] = '.';
                  rows[r] ^= mask;
                  cols[c] ^= mask;
                  mat[r / 3][c / 3] ^= mask;
              }
          }
  
          return false;
      }
  
      public void solveSudokuBits(char[][] board) {
          ArrayList<pair> arr = new ArrayList<>();
          rows = new int[9];
          cols = new int[9];
          mat = new int[3][3];
  
          for (int i = 0; i < 9; i++) {
              for (int j = 0; j < 9; j++) {
                  if (board[i][j] == '.') {
                      arr.add(new pair(i, j)); // i * 9 + j
                  } else {
                      int mask = 1 << (board[i][j] - '0');
                      rows[i] ^= mask;
                      cols[j] ^= mask;
                      mat[i / 3][j / 3] ^= mask;
                  }
              }
          }
  
          solveSudokuBits(board, 0, arr);
      }
  
}
