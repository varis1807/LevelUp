
public class ratInMazeWithMultipleJumpsAllow {
      public static void display(int[][] matAns) {
            for (int[] a : matAns) {
                  for (int ele : a)
                        System.out.print(ele + " ");
                  System.out.println();

            }
      }

      public static boolean ratInMaze(int sr, int sc, int[][] board, String[] dirS, int[][] dir, String ans, int[][] matAns) {
            int n = board.length;
            int m = board[0].length;
            if (sr == n - 1 && sc == m - 1) {
                  matAns[sr][sc] = 1;
                  display(matAns);
                  System.out.println(ans);
                  return true;
            }

            
            int jumps=board[sr][sc];
            matAns[sr][sc]=1;//  print
            boolean res = false;
            for (int d = 0; d < dir.length; d++) {
                  for (int rad = 1; rad <= jumps; rad++) {
                        int r = sr + rad * dir[d][0];
                        int c = sc + rad * dir[d][1];

                        if (r >= 0 && c >= 0 && r < n && c < m) {
                              if (board[r][c] != 0)
                                    res =res|| ratInMaze(r, c, board, dirS, dir, ans + dirS[d], matAns);
                        }else
                        break;
                  }
            }
            
            matAns[sr][sc] = 0;
            return res;
      }

      public static void main(String[] args) {
            int[][] board = { { 3, 0, 0, 2, 1 }, { 0, 0, 0, 0, 2 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 1 },
                        { 3, 0, 0, 1, 1 } };
            String[] dirS = { "R", "D" };
            int[][] dir = { { 0, 1 }, { 1, 0 } };
            int[][] matAns = new int[5][5];
            boolean res=ratInMaze(0, 0, board, dirS, dir, "", matAns);
            if(!res){
                  System.out.println(" no path  exist");
            }
      }
}

// Que====>
// A variation of Rat in a Maze : multiple steps or jumps allowed
// Difficulty Level : Hard
// Last Updated : 15 Jun, 2021
// A variation of rat in a maze.
// You are given an N * N 2-D matrix shaped maze (let’s call it M), there is a
// rat in the top-left cell i.e. M[0][0] and there is an escape door in the
// bottom-right cell i.e. M[N-1][N-1]. From each cell M[i][j] (0 ≤ i ≤ N-1, 0 ≤
// j ≤ N-1) the rat can go a number of steps towards its right ( for eg: to
// M[i][j+ s]), or a number of steps downwards ( for eg: to M[i+ s][j]), where
// the maximum number of steps (or maximum value of s) can be the value in the
// cell M[i][j]. If any cell contains 0 then that is a dead-end. For eg: In the
// second picture in the figure below, the rat at M[0][0] can jump to a cell :
// M[0][1], M[0][2], M[1][0] or M[2][0].

// You have to print a possible path from M[0][0] to M[N-1][N-1] in the form of
// a matrix of size N * N such that the cells that are in the path have a value
// 1 and other cells have a value 0. For the above example one such solution is
// :

// There is a backtracking solution for this problem in this article.
// Here a Dynamic Programming based solution is presented.
// Examples:

// Input: mat[][] = {
// {3, 0, 0, 2, 1},
// {0, 0, 0, 0, 2},
// {0, 1, 0, 1, 0},
// {1, 0, 0, 1, 1},
// {3, 0, 0, 1, 1} }
// Output:
// 1 0 0 1 1
// 0 0 0 0 1
// 0 0 0 0 0
// 0 0 0 0 1
// 0 0 0 0 1
// Input: mat[][] = { {0, 0}, {0, 1} }
// Output: No path exists