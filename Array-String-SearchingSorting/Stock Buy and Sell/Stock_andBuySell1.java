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
      public static int maxProfit1(int[] prices) {
            int dpi0=0;
            int dpi1=-(int)1e9;
            for(int i=0; i<prices.length; i++){
                dpi0=Math.max(dpi0,dpi1+prices[i]);
                dpi1=Math.max(dpi1,0-prices[i]);
            }
            return dpi0;
         }
}