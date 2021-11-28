public class Stock_andBuySell1 {
      // lc-> 121
      // O(n^2)
      public static int maxProfit(int[] prices) {
            int maxCur = 0, maxSoFar = 0;
            for (int i = 1; i < prices.length; i++) {
                  maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
                  maxSoFar = Math.max(maxCur, maxSoFar);
            }
            return maxSoFar;
      }
}