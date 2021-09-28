public class goldMine1 {

    // // With DFS
    // int max = 0;
    // public int getMaximumGold(int[][] grid) {

    // int r = grid.length;
    // int c = grid[0].length;
    // for(int i = 0; i < r; i++) {
    // for(int j = 0; j < c; j++) {
    // if(grid[i][j] != 0) {
    // collectGold(grid, i, j, 0);
    // }
    // }
    // }
    // return max;
    // }

    // private void collectGold(int[][] grid, int i, int j, int cur) {
    // if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length ||grid[i][j]== 0)
    // {
    // max = Math.max(max, cur);
    // return;
    // }
    // int val = grid[i][j];
    // grid[i][j] = 0;
    // collectGold(grid, i + 1, j, cur + val);
    // collectGold(grid, i - 1, j, cur + val);
    // collectGold(grid, i, j + 1, cur + val);
    // collectGold(grid, i, j - 1, cur + val);
    // grid[i][j] = val;
    // }

    public static int floodFill(int sr, int sc, int[][] grid, int[][] dir) {
        int m = grid[0].length, n = grid.length, maxSum = 0;
        int val = grid[sr][sc];
        grid[sr][sc] = -grid[sr][sc];
        for (int d = 0; d < 4; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] > 0) {
                int recAns = floodFill(r, c, grid, dir);
                if (recAns > maxSum)
                    maxSum = recAns;
            }
        }
        grid[sr][sc] = -grid[sr][sc];
        return maxSum + val;
    }

    public static int getMaximumGold(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = grid[0].length, n = grid.length, maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0)
                    maxSum = Math.max(maxSum, floodFill(i, j, grid, dir));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int grid[][]={{0,6,0},
                      {5,8,7},
                      {0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
}
