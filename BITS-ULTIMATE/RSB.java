public class RSB {
      public static int countBit(int n) {
            int count = 0;
            while (n != 0) {
                  int rsbMask = n & -n;
                  n -= rsbMask;
                  count++;
            }
            return count;
      }

      public static void main(String[] args) {
            System.out.println(countBit(25464545));
      }
}