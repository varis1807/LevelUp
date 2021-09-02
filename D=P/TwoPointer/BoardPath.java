public class BoardPath {
      public static int boardPath(int sp, int ep) {
            if (sp == ep)
                  return 1;
            int count = 0;
            for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                  count += boardPath(sp + dice, ep);
            }
            return count;
      }

      public static int boardPath_memo(int sp, int ep, int[] dp) {
            if (sp == ep) {
                  return dp[sp] = 1;
            }

            if (dp[sp] != 0)
                  return dp[sp];

            int count = 0;
            for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                  count += boardPath_memo(sp + dice, ep, dp);
            }

            return dp[sp] = count;
      }

      public static int boardPath_tabu(int SP, int ep, int[] dp) {
            for (int sp = ep; sp >= 0; sp--) {
                  if (sp == ep) {
                        dp[sp] = 1;
                        continue;
                  }

                  int count = 0;
                  for (int dice = 1; dice <= 6 && sp + dice <= ep; dice++) {
                        count += dp[sp + dice];// boardPath_memo(sp + dice, ep, dp);
                  }

                  dp[sp] = count;
            }

            return dp[SP];
      }
      public static void main(String[] args) {
            int ep=5;
            int dp[]=new int[ep+1];
            System.out.println(boardPath_tabu(1, ep,dp));
      }
}
