import java.util.*;
public class isValidSudoku {
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
  
      // 36
    public boolean isValidSudoku(char[][] board) {
      rows = new int[9];
      cols = new int[9];
      mat = new int[3][3];

      for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
              if (board[i][j] != '.') {
                  int mask = 1 << (board[i][j] - '0');
                  if ((rows[i] & mask) == 0 && (cols[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {
                      rows[i] ^= mask;
                      cols[j] ^= mask;
                      mat[i / 3][j / 3] ^= mask;
                  } else {
                      return false;
                  }
              }
          }
      }

      return true;
  } 
}
