public class OFF_To_ON {
      // 0 -> 1, 1 -> 1 / false -> true, true -> true // -> arr[idx] = true;
      public static void offToOn(int n, int k) {
            int mask = (1 << k);
            int ans = (n | mask);
            System.out.println(ans);
      }

      public static void main(String[] args) {
            int n = 309;
            int k = 3;
            offToOn(n, k);
      }
}
