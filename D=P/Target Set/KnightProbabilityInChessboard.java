public class KnightProbabilityInChessboard {
    static int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static double knightProbability_rec(int n, int k, int row, int col) {
        if (k == 0)
            return 1.0;
        double count = 0;
        for (int d = 0; d < 8; d++) {
            int r = row + dx[d];
            int c = col + dy[d];

            if (r >= 0 && c >= 0 && r < n && c < n) {
                count += knightProbability_rec(n, k - 1, r, c);
            }
        }
        return count / 8.0;
    }

    public static double knightProbability_(int n, int k, int row, int col, double[][][] dp) {
        if (k == 0)
            return dp[k][row][col] = 1.0;
        if (dp[k][row][col] != 0.0)
            return dp[k][row][col];

        double count = 0;
        for (int d = 0; d < 8; d++) {
            int r = row + dx[d];
            int c = col + dy[d];

            if (r >= 0 && c >= 0 && r < n && c < n) {
                count += knightProbability_(n, k - 1, r, c, dp);
            }
        }

        return dp[k][row][col] = count / 8.0;
    }

    public static void display(double[] dp) {
        for (double ele : dp) {
            System.out.print(ele + " | ");
        }
        System.out.println();
    }

    public static void display2D(double[][] dp) {
        for (double[] d : dp) {
            display(d);
        }
        System.out.println();
    }

    public static void display3D(double[][][] dp) {
        for (double[][] d : dp) {
            display2D(d);
        }
        System.out.println();
    }

    public static void knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n + 1][n + 1];
        System.out.println(knightProbability_(n, k, row, column, dp));
        display3D(dp);
    }

    public static void main(String[] args) {
        knightProbability(5, 2, 0, 0);
    }
}
