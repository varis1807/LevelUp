public class longSStrAtMost2DistChar {
      public int lengthOfLongestSubstringTwoDistinct(String s) {
            int si = 0, ei = 0, count = 0, n = s.length(), len = 0;
            int[] freq = new int[128];
            while (ei < n) {
                  if (freq[s.charAt(ei)] == 0)
                        count++;
                  freq[s.charAt(ei)]++;
                  ei++;
                  while (count > 2) {
                        if (freq[s.charAt(si)] == 1)
                              count--;
                        freq[s.charAt(si)]--;
                        si++;
                  }
                  len = Math.max(len, ei - si);
            }

            return len;
      }
}
