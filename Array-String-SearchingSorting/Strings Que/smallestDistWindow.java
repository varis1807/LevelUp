public class smallestDistWindow {
      public String findSubString(String s) {
            int[] req = new int[128];
            int need = 0;
            for (int i = 0; i < s.length(); i++) {
                  if (req[s.charAt(i)] == 0) {
                        req[s.charAt(i)]++;
                        need++;
                  }
            }

            int ei = 0;
            int si = 0, s1 = s.length(), len = (int) 1e9, gSI = 0;

            while (ei < s1) {
                  if (req[s.charAt(ei)] > 0)
                        need--;
                  req[s.charAt(ei)]--;
                  ei++;

                  while (need == 0) {
                        if (len > (ei - si)) {
                              len = ei - si;
                              gSI = si;
                        }
                        if (req[s.charAt(si)] == 0)
                              need++;

                        req[s.charAt(si)]++;
                        si++;
                  }
            }
            return s.substring(gSI, gSI + len);
      }

      // Given a string 's'. The task is to find the smallest window length that
      // contains all the characters of the given string at least one time.
      // For eg. A = “aabcbcdbca”, then the result would be 4 as of the smallest
      // window will be “dbca”.

      // Example 1:

      // Input : "AABBBCBBAC"
      // Output : 3
      // Explanation : Sub-string -> "BAC"
      // Example 2:
      // Input : "aaab"
      // Output : 2
      // Explanation : Sub-string -> "ab"

      // Example 3:
      // Input : "GEEKSGEEKSFOR"
      // Output : 8
      // Explanation : Sub-string -> "GEEKSFOR"

}
