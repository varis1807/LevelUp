// 647. Palindromic Substrings
public class PalinSubstring {
      // 6ms
      int count = 0;

      private void extendPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  count++;
                  left--;
                  right++;
            }
      }

      public int countSubstrings_(String s) {
            if (s == null || s.length() == 0)
                  return 0;

            for (int i = 0; i < s.length(); i++) { // i is the mid point
                  extendPalindrome(s, i, i); // odd length;
                  extendPalindrome(s, i, i + 1); // even length
            }

            return count;
      }

      public int countSubstrings(String s) {
            int n = s.length();
            boolean[][] PalinDP = new boolean[n][n];
            for (int gap = 0; gap < n; gap++) {
                  for (int i = 0, j = gap; j < n; i++, j++) {
                        if (gap == 0)
                              PalinDP[i][j] = true;
                        else if (gap == 1 && s.charAt(i) == s.charAt(j))
                              PalinDP[i][j] = true;
                        else
                              PalinDP[i][j] = s.charAt(i) == s.charAt(j) && PalinDP[i + 1][j - 1];

                        if (PalinDP[i][j])
                              count++;
                  }
            }
            return count;
      }
}
