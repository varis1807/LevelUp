public class gcd {
      public static int GCD(int a, int b) {
            if (b == 0)
                  return a;
            return GCD(b, a % b);
      }

      public static void main(String[] args) {
            System.out.println(GCD(2, 2));
      }
}
