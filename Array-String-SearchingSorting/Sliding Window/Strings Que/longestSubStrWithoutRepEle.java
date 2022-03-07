public class longestSubStrWithoutRepEle {
      public static int lengthOfLongestSubstring(String s) {
            int si = 0, ei = 0, count = 0, n = s.length(), len = 0;
            int globalSI = 0, globalEI = 0;
            int[] freq = new int[128];
            while (ei < n) {
                  if (freq[s.charAt(ei)] == 1)
                        count++;
                  freq[s.charAt(ei)]++;
                  ei++;
                  while (count > 0) {
                        if (freq[s.charAt(si)] == 2)
                              count--;
                        freq[s.charAt(si)]--;
                        si++;
                  }
                  // len = Math.max(len, ei - si);
                  if (len < ei - si) {
                        globalEI = ei;
                        globalSI = si;
                        len = Math.max(len, ei - si);
                  }
            }
            System.out.println(s.substring(globalSI, globalEI));
            return len;
      }

      public static void main(String[] args) {
            String str = "abcbcbb";
            System.out.println(lengthOfLongestSubstring(str));
      }
}
