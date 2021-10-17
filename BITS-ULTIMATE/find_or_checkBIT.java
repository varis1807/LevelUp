public class find_or_checkBIT {
      public static void find(int n, int i) {
            int mask = 1 << i;
            int set = n & mask;
            if (set >> i == 1)
                  System.out.println(1);
            else
                  System.out.println(0);
      }

      public static void main(String[] args) {
            find(309, 6);
      }
}
