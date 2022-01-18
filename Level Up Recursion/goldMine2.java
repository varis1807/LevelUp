import java.util.*;

public class goldMine2 {

      public static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag) {
            if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true) {
                  return;

            }

            visited[i][j] = true;
            bag.add(arr[i][j]);
            travelAndCollectGold(arr, i - 1, j, visited, bag);
            travelAndCollectGold(arr, i, j + 1, visited, bag);
            travelAndCollectGold(arr, i, j - 1, visited, bag);
            travelAndCollectGold(arr, i + 1, j, visited, bag);
      }

      public static int max = -(int) 1e9;

      public static void getMaxGold(int[][] arr) {
            boolean[][] visited = new boolean[arr.length][arr[0].length];

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] != 0 && visited[i][j] == false) {
                              ArrayList<Integer> bag = new ArrayList<>();
                              travelAndCollectGold(arr, i, j, visited, bag);

                              int sum = 0;
                              for (int val : bag) {
                                    sum += val;
                              }
                              if (sum > max) {
                                    max = sum;
                              }
                        }
                  }
            }
            System.out.println(max);
      }

      public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

      public static void main(String[] args) {
            int[][] mat = {
                        { 10, 0, 100, 200, 0, 8, 0 },
                        { 20, 0, 0, 0, 0, 6, 0 },
                        { 30, 0, 0, 9, 12, 3, 4 },
                        { 40, 0, 2, 5, 8, 3, 11 },
                        { 0, 0, 0, 0, 0, 9, 0 },
                        { 5, 6, 7, 0, 7, 4, 2 },
                        { 8, 9, 10, 0, 1, 10, 8 } };
            getMaxGold(mat);
            // int maxSum = -(int) 1e9;
            // for (int i = 0; i < mat.length; i++) {
            // for (int j = 0; j < mat[i].length; j++) {
            // if (mat[i][j] > 0)
            // maxSum = Math.max(maxSum, getMaxGold(i, j, mat, dir));
            // }
            // }
            // System.out.println(maxSum);
      }

      // public static int collectGold(int sr, int sc, int[][] mat, int[][] dir) {
      // int n = mat.length;
      // int m = mat[0].length, maxSum = 0;
      // int val = mat[sr][sc];
      // mat[sr][sc]=-mat[sr][sc];
      // for (int[] d : dir) {
      // int r = sr + d[0];
      // int c = sc + d[1];
      // if (r >= 0 && c >= 0 && r < n && c < m && mat[r][c] > 0) {
      // int recAns = collectGold(r, c, mat, dir);
      // if (maxSum < recAns)
      // maxSum = recAns;
      // }
      // }
      // mat[sr][sc]=-mat[sr][sc];
      // return maxSum + val;
      // }
}