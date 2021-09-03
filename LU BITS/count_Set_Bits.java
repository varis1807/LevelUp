public class count_Set_Bits {
      public static int countSetBits(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                  int mask = (1 << i);
                  if ((n & mask) != 0)
                        count++;
            }
            return count;
      }

      public static int countSetBits_02(int n) {
            int count = 0;
            while (n != 0) {
                  if ((n & 1) != 0)
                        count++;
                  n >>>= 1;
            }
            return count;
      }

      public static int countSetBits_03(int n) {
            int count = 0;
            while (n != 0) {
                  n &= (n - 1);
                  count++;
            }
            return count;
      }
}
