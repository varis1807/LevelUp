import java.util.*;

public class FriendsPairing2 {
      public static Scanner scn = new Scanner(System.in);
      public static void friendsPairing(int count, int n, boolean[] used, String asf) {
            if (count == n) {
                  System.out.println(asf);
                  return;
            }
            int fup = 1;
            while (fup <= n && used[fup])
                  fup++;
            used[fup] = true;
            friendsPairing(count + 1, n, used, asf + "(" + fup + ")");

            for (int pp = fup + 1; pp <= n; pp++) {
                  if (!used[pp]) {
                        used[pp] = true;
                        friendsPairing(count + 2, n, used, asf + "(" + fup + "," + pp + ")");
                        used[pp] = false;
                  }
            }
            used[fup] = false;
      }

      public static void main(String[] args) {
            int n = scn.nextInt();
            boolean[] used = new boolean[n + 1];
            friendsPairing(0, n, used, "");
      }
}
