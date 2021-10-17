public class OFF_to_ON {
      public static void setithBit(int n, int i) {
            int mask = 1 << i;
            int ans = n | mask;
            System.out.println(ans);
      }
      public static void main(String[] args) {
            setithBit(309, 3);
      }
}
