public class longSStrAtMostKdistChar {
      public static int longestkSubstr(String s, int k) {
            int si = 0, ei = 0, count = 0, n = s.length(), len = -1;
            int[] freq = new int[128];
            while (ei < n) {
                  if (freq[s.charAt(ei)] == 0)
                        count++;
                  freq[s.charAt(ei)]++;
                  ei++;
                  while (count > k) {
                        if (freq[s.charAt(si)] == 1)
                              count--;
                        freq[s.charAt(si)]--;
                        si++;
                  }
                  if (count == k)
                        len = Math.max(len, ei - si);
            }

            return len;
      }
}
