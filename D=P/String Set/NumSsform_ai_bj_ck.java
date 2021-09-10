public class NumSsform_ai_bj_ck {
      // https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
      public int fun(String s) {
            int n = s.length();
            long emptyCount = 1, aCount = 0, bCount = 0, cCount = 0, mod = (long) 1e9 + 7;
            for (int i = 0; i < n; i++) {
                  char ch = s.charAt(i);

                  if (ch == 'a')
                        aCount = aCount + (emptyCount + aCount) % mod;
                  else if (ch == 'b')
                        bCount = bCount + (aCount + bCount) % mod;
                  else if (ch == 'c')
                        cCount = cCount + (bCount + cCount) % mod;
            }

            return (int) (cCount % mod);
      }
}
