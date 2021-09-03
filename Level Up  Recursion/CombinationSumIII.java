public class CombinationSumIII {
      public static int infiCombination(int[] coins, int tar, int idx, String asf) {
            if (tar == 0) {
                  System.out.println(asf);
                  return 1;
            }
            int count = 0;
            for (int i = idx; i < coins.length; i++) {
                  if (tar - coins[i] >= 0) {
                        count += infiCombination(coins, tar - coins[i], i, asf + coins[i] + " ");
                  }
            }

            return count;
      }

      public static void main(String[] args) {
            int[] coins = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            System.out.println(infiCombination(coins, 7, 0, ""));
      }
}
