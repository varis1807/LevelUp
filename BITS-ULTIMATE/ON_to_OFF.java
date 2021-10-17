public class ON_to_OFF {
      public static void clearBit(int n, int i) {
            int mask = 1 << i;
            int ans = n & (~mask);
            System.out.println(ans);
      }

      public static void main(String[] args) {
            clearBit(309, 4);
      }
}
