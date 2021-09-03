public class ON_To_OFF {
      // 1 -> 0, 0 -> 0 / true -> false, false -> false // -> arr[idx] = false;
      public static void onToOff(int n, int k) {
            int mask = (1 << k);
            // n &= (~mask);
            int ans = (n & (~mask));
            System.out.println(ans);
      }

      public static void main(String[] args) {
            int n = 309;
            int k = 4;
            onToOff(n, k);
      }
}