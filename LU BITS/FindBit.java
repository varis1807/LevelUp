import java.util.Scanner;

public class FindBit {
      public static Scanner scn = new Scanner(System.in);
      public static void findithBit(int i, int n) {
            int mask = 1 << i;
            int ans = n & mask;
            System.out.println(ans);
            // if (((n & mask) >> i) == 1) {
            //       System.out.println(1);
            // } else
            //       System.out.println(0);
            if(ans==0)
            System.out.println(0);
            else
            System.out.println(1);
      }

      public static void main(String[] args) {
            int n = 309;
            int i = 5;
            findithBit(i, n);
      }
}
